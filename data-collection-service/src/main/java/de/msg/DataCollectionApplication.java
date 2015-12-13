package de.msg;

import de.msg.model.CarSensorData;
import de.msg.repository.SimpleCarSensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext} and
 * generates some simple example test data.
 */
@SpringBootApplication
@EnableEurekaClient
public class DataCollectionApplication {
    @Autowired
    private SimpleCarSensorDataRepository repository;

    /**
     * Generates some test data.
     */
    @PostConstruct
    private void generateTestData() {
        Set<CarSensorData> sensorDataSet = new HashSet<>();
        LocalDateTime now = LocalDateTime.now();
        long sensorValue = 20;

        // Emulates deterioration of a break pad over time.
        for (short i = 0; i < 20; i++) {
            now = now.plusMonths(i);
            long timestamp = now.toInstant(ZoneOffset.UTC).toEpochMilli();
            sensorValue--;

            sensorDataSet.add(new CarSensorData(timestamp, 1L, "brake_pad_front_left", String.valueOf(sensorValue)));
        }

        repository.save(sensorDataSet);
    }

    /**
     * Main method as entry point of {@link DataCollectionApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(DataCollectionApplication.class).web(true).run(args);
    }
}