package de.msg.service;

import de.msg.command.GetCarSensorDataCommand;
import de.msg.command.ScheduleCarMaintenanceCommand;
import de.msg.model.CarMaintenanceEvent;
import de.msg.model.CarSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * The {@link MaintenanceService} fetches all {@link CarSensorData} via {@link GetCarSensorDataCommand}, evaluates if
 * car maintenance is required. If sensor data indicates an needed maintenance an {@link CarMaintenanceEvent} is scheduled
 * via {@link ScheduleCarMaintenanceCommand}.
 * In more sophisticated scenarios you would use a configurable business rule engine, like Drools.
 * See <a href="http://www.drools.org/">http://www.drools.org</a>
 */
@Service
public class MaintenanceService {
    @Autowired
    private GetCarSensorDataCommand getCarSensorDataCommand;
    @Autowired
    private ScheduleCarMaintenanceCommand scheduleCarMaintenanceCommand;

    /**
     * Fetches all {@link CarSensorData} end evaluates if car maintenance is required.
     * If car maintenance is required a {@link CarMaintenanceEvent} is created.
     *
     * @return All {@link CarSensorData} instances that are the primary cause of the scheduled car maintenance.
     */
    public CarSensorData[] evaluateMaintenance() {
        // Fetch all CarSensorData instances
        CarSensorData[] sensorData = getCarSensorDataCommand.getSensorData();
        // Sort CarSensorData by timestamp
        Arrays.sort(sensorData, (o1, o2) -> {
            LocalDateTime d1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(o1.getTimestamp()), ZoneOffset.UTC);
            LocalDateTime d2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(o2.getTimestamp()), ZoneOffset.UTC);
            return d1.compareTo(d2);
        });

        // Evaluates of car maintenance is required. In this particular example we schedule a CarMaintenanceEvent when
        // the brake pad width falls below 4mm.
        CarSensorData[] result = Arrays.stream(sensorData)
                .filter(carSensorData -> carSensorData.getSensorName().equals("brake_pad_front_left"))
                .filter(carSensorData -> Long.valueOf(carSensorData.getSensorValue()) < 4L)
                .toArray(CarSensorData[]::new);

        // If the brake pad has been changed and its width is greater than 4 mm again, an CarMaintenanceEvent is wrongly
        // scheduled.
        if (result.length > 0) {
            CarMaintenanceEvent event = new CarMaintenanceEvent(result[0]);
            scheduleCarMaintenanceCommand.scheduleCarMaintenanceCommand(event);
            return result;
        } else {
            return new CarSensorData[0];
        }
    }
}
