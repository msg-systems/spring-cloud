package de.msg;

import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link MaintenanceApplication} evaluates if car maintenance is required. If maintenance is required {@link SensorEvent}
 * data is fetched from data-collection-service and a {@link MaintenanceEvent} is generated and posted to car-repair-service.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MaintenanceApplication {

    /**
     * Main method as entry point of {@link MaintenanceApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(MaintenanceApplication.class).web(true).run(args);
    }
}