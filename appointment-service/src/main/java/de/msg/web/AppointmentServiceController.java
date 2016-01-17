package de.msg.web;

import de.msg.model.Appointment;
import de.msg.model.Customer;
import de.msg.model.ServiceCenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * The {@link AppointmentServiceController} schedules an appointment in one month from now.
 */
@RestController
public class AppointmentServiceController {
    // Stateful Controller avoid this in production due scaling issues.
    private final long now = LocalDateTime.now().plusMonths(1L).toInstant(ZoneOffset.UTC).toEpochMilli();

    /**
     * Schedules an {@link Appointment} for the {@link Customer}
     *
     * @param customer The {@link Customer} to schedule the {@link Appointment} for.
     * @return The scheduled moment of the {@link Appointment} as {@link LocalDateTime} long.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/customers/schedule", produces = "application/x-spring-data-compact+json")
    public ResponseEntity<Long> scheduleAppointment(@RequestBody Customer customer) {
        return ResponseEntity.ok(now);
    }

    /**
     * Schedules an {@link Appointment} for the {@link Customer}
     *
     * @param serviceCenter The {@link Customer} to schedule the {@link Appointment} for.
     * @return The scheduled moment of the {@link Appointment} as {@link LocalDateTime} long.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/serviceCenters/schedule", produces = "application/x-spring-data-compact+json")
    public ResponseEntity<Long> scheduleAppointment(@RequestBody ServiceCenter serviceCenter) {
        return ResponseEntity.ok(now);
    }
}
