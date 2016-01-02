package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link MaintenanceApplication} fetches sensor data from data-collection-service and evaluates if car maintenance
 * is required an {@link de.msg.domain.carmaintenance.CarMaintenance} is generated and pushed to car-repair-service.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
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