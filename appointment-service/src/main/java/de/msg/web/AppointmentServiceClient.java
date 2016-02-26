package de.msg.web;

import de.msg.model.Appointment;
import de.msg.model.Customer;
import de.msg.model.ServiceCenter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

/**
 * {@link FeignClient} communicating with <tt>appointment-service</tt>.
 */
@FeignClient(value = "appointment-service")
public interface AppointmentServiceClient {
    /**
     * Schedules an {@link Appointment} for the {@link Customer}
     *
     * @param customer The {@link Customer} to schedule the {@link Appointment} for.
     * @return The scheduled moment of the {@link Appointment} as {@link LocalDateTime} long.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/customers/schedule", consumes = "application/x-spring-data-compact+json")
    ResponseEntity<Long> scheduleAppointment(@RequestBody Customer customer);

    /**
     * Schedules an {@link Appointment} for the {@link ServiceCenter}
     *
     * @param serviceCenter The {@link ServiceCenter} to schedule the {@link Appointment} for.
     * @return The scheduled moment of the {@link Appointment} as {@link LocalDateTime} long.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/serviceCenters/schedule", consumes = "application/x-spring-data-compact+json")
    ResponseEntity<Long> scheduleAppointment(@RequestBody ServiceCenter serviceCenter);

    /**
     * Schedules an {@link Appointment}
     *
     * @param appointment The {@link Appointment} for.
     * @return The scheduled{@link Appointment}
     */
    @RequestMapping(method = RequestMethod.POST, value = "/appointments/", consumes = "application/x-spring-data-compact+json")
    ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment);
}
