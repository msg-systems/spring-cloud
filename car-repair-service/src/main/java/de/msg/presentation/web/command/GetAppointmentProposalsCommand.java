package de.msg.presentation.web.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import de.msg.domain.customer.Customer;
import de.msg.domain.servicecenter.ServiceCenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * This {@link HystrixCommand} fetches appointment proposals for the {@link Customer} and the {@link ServiceCenter}.
 */
@Component
public class GetAppointmentProposalsCommand {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches the appointment proposals for the {@link Customer} <code>customer</code>.
     *
     * @return The {@link LocalDateTime} with appointment proposals for the {@link Customer}.
     */
    @HystrixCommand
    public LocalDateTime getCustomerAppointmentProposals(Customer customer) {
        // TODO RK use customer
        long proposal = restTemplate.getForObject("http://appointment-service/customer", Long.class);
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(proposal), ZoneOffset.UTC);
    }

    /**
     * Fetches the appointment proposals for the {@link ServiceCenter} <code>serviceCenter</code>.
     *
     * @return The {@link LocalDateTime} with appointment proposals for the {@link ServiceCenter}.
     */
    @HystrixCommand
    public LocalDateTime getServiceCenterAppointmentProposals(ServiceCenter serviceCenter) {
        // TODO RK use serviceCenter
        long proposal = restTemplate.getForObject("http://appointment-service/service-center", Long.class);
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(proposal), ZoneOffset.UTC);
    }
}
