package de.msg.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;
import de.msg.repository.MaintenanceEventRepository;
import de.msg.web.DataCollectionServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import de.msg.domain.carmaintanance.CarMaintenance;
import de.msg.domain.customer.Customer;
import de.msg.domain.servicecenter.ServiceCenter;
import de.msg.presentation.web.command.GetAppointmentProposalsCommand;
import de.msg.presentation.web.command.GetCustomerMasterDataCommand;
import de.msg.presentation.web.command.ScheduleAppointmentCommand;

/**
 * The {@link CarRepairService} is a {@link Service} responsible for scheduling car maintenance.
 */
@Service
public class CarRepairService {
    @Autowired
    private GetCustomerMasterDataCommand getCustomerMasterDataCommand;
    @Autowired
    private GetAppointmentProposalsCommand getAppointmentProposalsCommand;
    @Autowired
    private ScheduleAppointmentCommand scheduleAppointmentCommand;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DataCollectionServiceClient client;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceEventRepository repository;

    /**
     * Schedules a {@link MaintenanceEvent}.
     *
     * @param event The {@link MaintenanceEvent} to schedule
     * @return The scheduled {@link MaintenanceEvent}
     */
    public MaintenanceEvent scheduleMaintenance(MaintenanceEvent event) {
        Set<PagedResources<SensorEvent>> pagedResources = client.findByCar(event.getCar());
        Set<SensorEvent> events = new HashSet<>();
        for (PagedResources<SensorEvent> page : pagedResources) {
            events.addAll(page.getContent());
        }
        event.setSensorEvents(events);
        repository.save(event);

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
    public CarMaintenance scheduleCarMaintenance(CarMaintenance event) {
        Customer customer = getCustomerMasterDataCommand.getCustomer(event.getCar());
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
