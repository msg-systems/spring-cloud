package de.msg.web;

import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import de.msg.service.MaintenanceService;

/**
 * The {@link MaintenanceServiceController} is a {@link RestController} evaluating maintenance of a car.
 * If maintenance is required an {@link SensorEvent} is generated and sent to car-repair-service.
 */
@RestController
public class MaintenanceServiceController {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceService service;

    /**
     * Evaluates if maintenance is required.
     *
     * @param sensorEvent The {@link SensorEvent}.
     * @return The {@link MaintenanceEvent} if maintenance is required.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sensorEvents/evaluate", produces = "application/x-spring-data-compact+json")
    public ResponseEntity<MaintenanceEvent> evaluateSensorEvent(@RequestBody SensorEvent sensorEvent) {
        boolean maintenance = service.evaluateMaintenance(sensorEvent);
        if (maintenance) {
            MaintenanceEvent maintenanceEvent = MaintenanceEvent.build(sensorEvent);

            service.scheduleMaintenanceEvent(maintenanceEvent);
            return ResponseEntity.ok(maintenanceEvent);
        }
        return ResponseEntity.ok(new MaintenanceEvent());
    }
}
