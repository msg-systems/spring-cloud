package de.msg.web;

import de.msg.model.MaintenanceEvent;
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
     * Schedules an {@link MaintenanceEvent}
     *
     * @param maintenanceEvent The {@link MaintenanceEvent} to schedule.
     * @return The scheduled {@link MaintenanceEvent}.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/maintenanceEvents/schedule", consumes = "application/x-spring-data-compact+json")
    ResponseEntity<MaintenanceEvent> scheduleMaintenanceEvent(@RequestBody MaintenanceEvent maintenanceEvent);
}
