package de.msg.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import de.msg.domain.carmaintanance.CarMaintenance;
import de.msg.domain.customer.Customer;
import de.msg.domain.servicecenter.ServiceCenter;
import de.msg.presentation.web.command.GetAppointmentProposalsCommand;
import de.msg.presentation.web.command.GetCustomerMasterDataCommand;
import de.msg.presentation.web.command.ScheduleAppointmentCommand;

/**
 * The {@link CarRepairService} is a {@link RestController} responsible for scheduling car maintenance.
 */
@Service
public class CarRepairService {
    @Autowired
    private GetCustomerMasterDataCommand getCustomerMasterDataCommand;
    @Autowired
    private GetAppointmentProposalsCommand getAppointmentProposalsCommand;
    @Autowired
    private ScheduleAppointmentCommand scheduleAppointmentCommand;

    /**
     * Schedules a {@link CarMaintenanceEvent}.
     *
     * @param event The {@link CarMaintenanceEvent} to schedule
     * @return The scheduled {@link CarMaintenanceEvent}
     */
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
