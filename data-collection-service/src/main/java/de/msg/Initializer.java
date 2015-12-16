package de.msg;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.msg.domain.carsenor.CarSensor;
import de.msg.domain.carsenor.CarSensorRepository;

/**
 * 
 * 
 * @author Rafael Kansy, Michael Schäfer 
 * */
@Component
public class Initializer {

	@Autowired
    private CarSensorRepository repository;

    /**
     * Generates some test data.
     */
    @PostConstruct
    private void generateTestData() {
        Set<CarSensor> sensorDataSet = new HashSet<>();
        LocalDateTime now = LocalDateTime.now();
        long sensorValue = 20;

        // Emulates deterioration of a break pad over time.
        for (short i = 0; i < 20; i++) {
            now = now.plusMonths(i);
            long timestamp = now.toInstant(ZoneOffset.UTC).toEpochMilli();
            sensorValue--;

            sensorDataSet.add(new CarSensor(timestamp, 1L, "brake_pad_front_left", String.valueOf(sensorValue)));
        }

        repository.save(sensorDataSet);
    }
	
	
}
