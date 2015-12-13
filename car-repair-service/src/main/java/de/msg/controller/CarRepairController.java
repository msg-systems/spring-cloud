package de.msg.controller;

import de.msg.model.CarMaintenanceEvent;
import de.msg.service.CarRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * The {@link CarRepairController} tries to schedule an car maintenance appointment with an {@link de.msg.model.Customer}
 * and {@link de.msg.model.ServiceCenter}.
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
    public CarMaintenanceEvent home() {
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        CarMaintenanceEvent result = new CarMaintenanceEvent(timestamp, 1L, "brake_pad_front_left", "4", 0);
        service.scheduleCarMaintenanceEvent(result);
        return result;
    }

    /**
     * Schedules a {@link CarMaintenanceEvent}.
     *
     * @return The scheduled {@link CarMaintenanceEvent}.
     */
    //TODO MS communication with car-repair-service throws java.lang.RuntimeException: Not implemented due required Ribbon dependency.
    @RequestMapping(method = RequestMethod.POST)
    public CarMaintenanceEvent scheduleMaintenance(@RequestBody CarMaintenanceEvent input) {
        service.scheduleCarMaintenanceEvent(input);
        return input;
    }
}
