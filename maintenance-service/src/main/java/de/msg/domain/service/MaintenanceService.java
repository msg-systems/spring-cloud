package de.msg.domain.service;

import de.msg.domain.carmaintenance.CarMaintenance;
import de.msg.domain.carsensor.CarSensor;
import de.msg.presentation.web.command.GetCarSensorCommand;
import de.msg.presentation.web.command.ScheduleCarMaintenanceCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * The {@link MaintenanceService} fetches all {@link CarSensor} via {@link GetCarSensorCommand}, evaluates if
 * car maintenance is required. If sensor data indicates an needed maintenance an {@link CarMaintenance} is scheduled
 * via {@link ScheduleCarMaintenanceCommand}.
 * In more sophisticated scenarios you would use a configurable business rule engine, like Drools.
 * See <a href="http://www.drools.org/">http://www.drools.org</a>
 */
@Service
public class MaintenanceService {


    /**
     * Fetches all {@link CarSensor} end evaluates if car maintenance is required.
     * If car maintenance is required a {@link CarMaintenance} is created.
     *
     * @param carSensor An {@link CarSensor[]} with sensor data to evaluate.
     * @return All {@link CarSensor} instances that are the primary cause of the scheduled car maintenance.
     */
    public CarSensor[] evaluateMaintenance(CarSensor[] carSensor) {

        // Sort CarSensorData by timestamp
        Arrays.sort(carSensor, (o1, o2) -> {
            LocalDateTime d1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(o1.getTimestamp()), ZoneOffset.UTC);
            LocalDateTime d2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(o2.getTimestamp()), ZoneOffset.UTC);
            return d1.compareTo(d2);
        });

        // Evaluates of car maintenance is required. In this particular example we schedule a CarMaintenanceEvent when
        // the brake pad width falls below 4mm.
        CarSensor[] result = Arrays.stream(carSensor)
                .filter(carSensorData -> carSensorData.getSensorName().equals("brake_pad_front_left"))
                .filter(carSensorData -> Long.valueOf(carSensorData.getSensorValue()) < 4L)
                .toArray(CarSensor[]::new);

        return result;
    }
}
