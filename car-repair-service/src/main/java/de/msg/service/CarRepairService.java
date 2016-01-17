package de.msg.service;

import de.msg.model.*;
import de.msg.presentation.web.command.GetAppointmentProposalsCommand;
import de.msg.presentation.web.command.ScheduleAppointmentCommand;
import de.msg.repository.MaintenanceEventRepository;
import de.msg.web.DataCollectionServiceClient;
import de.msg.web.MasterDataCustomerServiceClient;
import de.msg.web.MasterDataServiceCenterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@link CarRepairService} is a {@link Service} responsible for scheduling car maintenance.
 */
@Service
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CarRepairService {
    @Autowired
    private GetAppointmentProposalsCommand getAppointmentProposalsCommand;
    @Autowired
    private ScheduleAppointmentCommand scheduleAppointmentCommand;

    @Autowired
    private DataCollectionServiceClient dataCollectionServiceClient;
    @Autowired
    private MasterDataCustomerServiceClient masterDataCustomerServiceClient;
    @Autowired
    private MasterDataServiceCenterServiceClient masterDataServiceCenterServiceClient;
    @Autowired
    private MaintenanceEventRepository repository;

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

    /**
     * Schedules a {@link MaintenanceEvent}.
     *
     * @param event The {@link MaintenanceEvent} to schedule
     * @return The scheduled {@link MaintenanceEvent}
     */
    public MaintenanceEvent scheduleMaintenance(MaintenanceEvent event) {
        Set<PagedResources<SensorEvent>> pagedSensorEvents = dataCollectionServiceClient.findByCar(event.getCar());
        Collection<SensorEvent> events = parseEmbeddedJsonResponse(pagedSensorEvents);
        event.setSensorEvents(new HashSet<>(events));
        repository.save(event);

        Set<PagedResources<Customer>> pagedCustomers = masterDataCustomerServiceClient.findByCar(event.getCar());
        Collection<Customer> customers = parseEmbeddedJsonResponse(pagedCustomers);
        Customer customer = getFirstElement(customers);

        Set<PagedResources<ServiceCenter>> pagedServiceCenter = masterDataServiceCenterServiceClient.findAll();
        Collection<ServiceCenter> serviceCenters = parseEmbeddedJsonResponse(pagedServiceCenter);
        // Get master-data
        // Get appointment proposals
        // Schedule service center appointment
        // Schedule customer appointment
        return event;
    }

    /**
     * Schedules a {@link CarMaintenance}.
     *
     * @param event The {@link CarMaintenance} to schedule
     * @return The scheduled {@link CarMaintenance}
     */
    @Deprecated
    public CarMaintenance scheduleCarMaintenance(CarMaintenance event, Customer customer) {
        LocalDateTime customerCenterProposal = getAppointmentProposalsCommand.getCustomerAppointmentProposals(customer);
        ServiceCenter serviceCenter = new ServiceCenter();
        LocalDateTime serviceCenterProposal = getAppointmentProposalsCommand.getServiceCenterAppointmentProposals(serviceCenter);

        if (serviceCenterProposal.equals(customerCenterProposal)) {
            scheduleAppointmentCommand.scheduleServiceCenterAppointment(serviceCenter, serviceCenterProposal);
            scheduleAppointmentCommand.scheduleCustomerAppointment(customer, customerCenterProposal);
            // TODO RK event.setAppointment()
        } else {
            // TODO RK implement some logic here.
        }
        return event;
    }
}
