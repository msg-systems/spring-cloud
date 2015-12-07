package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DataCollectionService {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DataCollectionService.class).web(true).run(args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    // Für jedes Auto werden Daten in einem bestimmten Zeitraum geliefert.
    // Welche Bremse (vorne, hinten, links, rechts)
    // Aktuelle Dicke des Bremsbelages
    //* CarData Entity oder SensorData
    // Timestamp
    // Car
    // Sensor
    // Value

    // Push Maintainance via REST-Controller
}