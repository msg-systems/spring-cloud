package de.msg.repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.msg.model.SensorEvent;

/**
 * Initializes sample {@link SensorEvent} data.
 */
@Component
public class SensorEventInitializer {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SensorEventRepository repository;

    public Set<SensorEvent> generateTestData(long car) {
        Set<SensorEvent> sensorDataSet = new HashSet<>();
        LocalDateTime now = LocalDateTime.now();

        // Emulates deterioration of a break pad over time.
        for (short i = 20; i >= 3; i--) {
            SensorEvent sensorData = repository.findByCarAndSensorNameAndSensorValue(car, "brake_pad_front_left", String.valueOf(i));
            if (sensorData == null) {
                now = now.plusMonths(i);
                long timestamp = now.toInstant(ZoneOffset.UTC).toEpochMilli();
                sensorDataSet.add(new SensorEvent(timestamp, car, "brake_pad_front_left", String.valueOf(i)));
            } else {
                sensorDataSet.add(sensorData);
            }
        }
        repository.save(sensorDataSet);
        return sensorDataSet;
    }
}
