package de.msg.web;

import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link FeignClient} communicating with <tt>maintenance-service</tt>.
 */
@FeignClient(value = "maintenance-service")
public interface MaintenanceServiceClient {
    /**
     * Evaluates if maintenance is required.
     *
     * @param event The {@link SensorEvent}.
     * @return The {@link MaintenanceEvent} if maintenance is required.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sensorEvents/evaluate", consumes = "application/x-spring-data-compact+json")
    ResponseEntity<MaintenanceEvent> evaluateSensorEvent(@RequestBody SensorEvent event);
}
