package de.msg.presentation.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.msg.domain.carmaintenance.CarMaintenance;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * The {@link AppointmentServiceController} schedules an appointment in one month from now.
 */
@RestController
public class AppointmentServiceController {
    private final long now = LocalDateTime.now().plusMonths(1L).toInstant(ZoneOffset.UTC).toEpochMilli();


    /**
     * Appointment for the customer.
     *
     * @return Appointment for the customer.
     */
    @RequestMapping(name = "scheduleCarMaintenance", method = RequestMethod.POST)
    public ResponseEntity<CarMaintenance> scheduleCarMaintenance(@RequestBody CarMaintenance carMaintenance) {
        // creates an appoinment for the maintennace
        return new ResponseEntity<>(new CarMaintenance(), HttpStatus.OK);
    }
}
