package de.msg.service;

import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;

import de.msg.repository.MaintenanceEventRepository;
import de.msg.web.CarRepairServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The {@link MaintenanceService} evaluates if maintenance is required by examining a {@link SensorEvent} instance.
 * If the {@link SensorEvent} data indicates that a maintenance is needed an {@link MaintenanceEvent} is scheduled.
 * In more sophisticated scenarios you would use a configurable business rule engine, like Drools.
 * See <a href="http://www.drools.org/">http://www.drools.org</a>
 */
@Service
public class MaintenanceService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CarRepairServiceClient client;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceEventRepository repository;

    /**
     * Fetches all {@link SensorEvent} and evaluates if car maintenance is required.
     * If car maintenance is required a {@link MaintenanceEvent} is created.
     *
     * @param sensorEvent An {@link SensorEvent} with sensor data to evaluate.
     * @return true if an maintenance is required.
     */
    public boolean evaluateMaintenance(SensorEvent sensorEvent) {
        // Evaluates if car maintenance is required. In this particular example we schedule a {@link MaintenanceEvent} when
        // the brake pad width falls below 4mm.
        return (sensorEvent.getSensorName().equals("brake_pad_front_left") && Long.valueOf(sensorEvent.getSensorValue()) < 4L);
    }

    /**
     * Schedules an {@link MaintenanceEvent}
     *
     * @param maintenanceEvent The {@link MaintenanceEvent} to schedule.
     */
    public void scheduleMaintenanceEvent(MaintenanceEvent maintenanceEvent) {
        repository.insert(maintenanceEvent);
        client.scheduleMaintenanceEvent(maintenanceEvent);
    }
}
