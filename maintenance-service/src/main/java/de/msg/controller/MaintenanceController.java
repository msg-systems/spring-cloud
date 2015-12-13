package de.msg.controller;

import de.msg.model.CarSensorData;
import de.msg.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link MaintenanceController} is a {@link RestController} evaluating if maintenance of a car is required.
 * If maintenance is required an {@link de.msg.model.CarMaintenanceEvent} is generated and sent to car-repair-service.
 */
@RestController
public class MaintenanceController {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceService service;

    /**
     * Evaluates if maintenance is required.
     *
     * @return All {@link CarSensorData} indicating car maintenance.
     */
    @RequestMapping("/")
    public CarSensorData[] home() {
        return service.evaluateMaintenance();
    }
}
