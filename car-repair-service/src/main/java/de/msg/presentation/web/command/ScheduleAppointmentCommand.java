package de.msg.presentation.web.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.msg.model.Customer;
import de.msg.model.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * This {@link HystrixCommand} schedules car maintenance appointment for the {@link Customer} and the {@link ServiceCenter}.
 */
@Component
public class ScheduleAppointmentCommand {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Schedules the appointment for the {@link Customer} <code>customer</code>.
     */
    @HystrixCommand
    public void scheduleCustomerAppointment(Customer customer, LocalDateTime appointment) {
        // TODO RK implement method
    }

    /**
     * Schedules the appointment for the {@link ServiceCenter} <code>serviceCenter</code>.
     */
    @HystrixCommand
    public void scheduleServiceCenterAppointment(ServiceCenter serviceCenter, LocalDateTime appointment) {
        // TODO RK implement method
    }
}
