package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MaintenanceService {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MaintenanceService.class).web(true).run(args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    // Erzeugt Wartung Ereignisse
    // Kann regelässig Daten vom DataCollectionServcie abrufen um Wartungs Ergebnisse zu berechnen
    // SensorData getSensorDataByCar(Long carId, Long sensorId)
    // evaluateRule(SensorData data)
    // createMaintainanceEvent(Car)
}