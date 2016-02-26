package de.msg.service;

import de.msg.model.Appointment;
import de.msg.model.MaintenanceEvent;
import de.msg.model.ServiceCenter;
import de.msg.web.AppointmentServiceClient;
import de.msg.web.CarRepairServiceClient;
import de.msg.web.MasterDataServiceCenterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * The {@link AppointmentService} is a {@link Service} responsible for scheduling {@link Appointment} instances.
 */
@Service
public class AppointmentService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MasterDataServiceCenterServiceClient masterDataServiceCenterServiceClient;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AppointmentServiceClient appointmentServiceClient;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CarRepairServiceClient carRepairServiceClient;

    /**
     * Schedules an {@link MaintenanceEvent}
     *
     * @param event The {@link MaintenanceEvent} to schedule.
     * @return The scheduled {@link MaintenanceEvent}.
     */
    public MaintenanceEvent scheduleMaintenanceEvent(MaintenanceEvent event) {

        // Send AppointmentRequests to customer and wait for customers response
        long customerAppointment = appointmentServiceClient.scheduleAppointment(event.getCustomer()).getBody();

        Set<PagedResources<ServiceCenter>> pagedServiceCenter = masterDataServiceCenterServiceClient.findAll();
        Collection<ServiceCenter> serviceCenters = parseEmbeddedJsonResponse(pagedServiceCenter);
        // Select an appropriate service center. Verify car brand and customer location i.e. Do some more sophisticated selection
        ServiceCenter serviceCenter = getFirstElement(serviceCenters);
        long serviceCenterAppointment = appointmentServiceClient.scheduleAppointment(serviceCenter).getBody();

        if (customerAppointment == serviceCenterAppointment) {
            Appointment appointment = new Appointment(event.getCustomer(), serviceCenter, customerAppointment);
            carRepairServiceClient.scheduleAppointment(appointment);
        } else {
            throw new RuntimeException("Unable to schedule appointment");
        }

        return event;
    }

    /**
     * Creates a {@link Collection<T>} of entities from a {@link Set<PagedResources>}
     */
    // TODO Figure out how consuming @RestRepository _embedded HAL-JSON Resources really works. This can not be state of the art.
    private static <T> Collection<T> parseEmbeddedJsonResponse(Set<PagedResources<T>> pagedResources) {
        Collection<T> result = new ArrayList<>();
        for (PagedResources<T> page : pagedResources) {
            result.addAll(page.getContent());
        }
        return result;
    }

    private static <T> T getFirstElement(Collection<T> collection) {
        if (!collection.isEmpty()) {
            return collection.iterator().next();
        } else {
            return null;
        }
    }
}
