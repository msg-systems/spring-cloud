package de.msg.web;

import de.msg.model.Appointment;
import de.msg.model.Customer;
import de.msg.model.ServiceCenter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * {@link FeignClient} communicating with <tt>car-repair-service</tt>.
 */
@FeignClient(value = "car-repair-service")
public interface CarRepairServiceClient {
    /**
     * Schedules an {@link Appointment}
     *
     * @param appointment The {@link Appointment} for.
     * @return The scheduled{@link Appointment}
     */
    @RequestMapping(method = RequestMethod.POST, value = "/appointments/", consumes = "application/x-spring-data-compact+json")
    ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment);
}
