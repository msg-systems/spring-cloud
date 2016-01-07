package de.msg.repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.msg.model.SensorValue;

import javax.annotation.PostConstruct;

/**
 * Initializes sample {@link SensorValue} data.
 *
 * @author Rafael Kansy
 */
@Component
public class SensorValueInitializer {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SensorValueRepository repository;

    /**
     * Generates some test data.
     */
    @PostConstruct
    private void generateTestData() {
        Set<SensorValue> sensorDataSet = new HashSet<>();
        LocalDateTime now = LocalDateTime.now();

        // Emulates deterioration of a break pad over time.
        for (short i = 20; i >= 3; i--) {
            SensorValue sensorData = repository.findByCarAndSensorNameAndSensorValue(1L, "brake_pad_front_left", String.valueOf(i));
            if (sensorData == null) {
                now = now.plusMonths(i);
                long timestamp = now.toInstant(ZoneOffset.UTC).toEpochMilli();
                sensorDataSet.add(new SensorValue(timestamp, 1L, "brake_pad_front_left", String.valueOf(i)));
            } else {
                sensorDataSet.add(sensorData);
            }
        }
        repository.save(sensorDataSet);
    }
}
