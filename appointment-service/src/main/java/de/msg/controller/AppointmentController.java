package de.msg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * The {@link AppointmentController} schedules an appointment in one month from now.
 */
@RestController
public class AppointmentController {
    private final long now = LocalDateTime.now().plusMonths(1L).toInstant(ZoneOffset.UTC).toEpochMilli();

    /**
     * Appointment for the customer.
     *
     * @return Appointment for the customer.
     */
    @RequestMapping("/customer")
    public long customerAppointment() {
        return now;
    }

    /**
     * Appointment for the service center.
     *
     * @return Appointment for the service center.
     */
    @RequestMapping("/service-center")
    public long serviceCenterAppointment() {
        return now;
    }
}
