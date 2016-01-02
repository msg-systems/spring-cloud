package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link CarRepairApplication} fetches appointment proposals from appointment-service and tries to schedule
 * an appointment for an {@link de.msg.domain.customer.Customer} in an {@link de.msg.domain.servicecenter.ServiceCenter} for car maintenance.
 */
@SpringBootApplication
@EnableEurekaClient
public class CarRepairApplication {

    /**
     * Main method as entry point of {@link CarRepairApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(CarRepairApplication.class).web(true).run(args);
    }
}