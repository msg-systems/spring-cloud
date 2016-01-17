package de.msg.web;

import de.msg.model.Customer;
import de.msg.model.MaintenanceEvent;
import de.msg.model.ServiceCenter;
import de.msg.service.CarRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link CarRepairController} tries to schedule an {@link MaintenanceEvent} for car maintenance and appointment
 * with a {@link Customer} and {@link ServiceCenter}.
 */
@RestController
public class CarRepairController {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CarRepairService service;

    /**
     * Schedules an {@link MaintenanceEvent}
     *
     * @param maintenanceEvent The {@link MaintenanceEvent} to schedule.
     * @return The scheduled {@link MaintenanceEvent}.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/maintenanceEvents/schedule", produces = "application/x-spring-data-compact+json")
    public ResponseEntity<MaintenanceEvent> scheduleMaintenanceEvent(@RequestBody MaintenanceEvent maintenanceEvent) {
        service.scheduleMaintenance(maintenanceEvent);
        return ResponseEntity.ok(maintenanceEvent);
    }
}
