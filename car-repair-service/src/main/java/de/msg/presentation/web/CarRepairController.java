package de.msg.presentation.web;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.msg.domain.carmaintanance.CarMaintenance;
import de.msg.domain.service.CarRepairService;

/**
 * The {@link CarRepairController} tries to schedule an car maintenance appointment with an {@link de.msg.domain.customer.Customer}
 * and {@link de.msg.domain.servicecenter.ServiceCenter}.
 */
@RestController
public class CarRepairController {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CarRepairService service;

    /**
     * Emulates scheduling a {@link CarMaintenanceEvent}.
     *
     * @return The scheduled {@link CarMaintenanceEvent}.
     */
    @RequestMapping
    public CarMaintenance home() {
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        CarMaintenance result = new CarMaintenance(timestamp, 1L, "brake_pad_front_left", "4", 0);
        service.scheduleCarMaintenance(result);
        return result;
    }

    /**
     * Schedules a {@link CarMaintenanceEvent}.
     *
     * @return The scheduled {@link CarMaintenanceEvent}.
     */
    //TODO MS communication with car-repair-service throws java.lang.RuntimeException: Not implemented due required Ribbon dependency.
    @RequestMapping(method = RequestMethod.POST)
    public CarMaintenance scheduleMaintenance(@RequestBody CarMaintenance input) {
        service.scheduleCarMaintenance(input);
        return input;
    }
}
