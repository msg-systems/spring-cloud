package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link AppointmentApplication} schedules appointments.
 */
@SpringBootApplication
@EnableEurekaClient
public class AppointmentApplication {

    /**
     * Main method as entry point of {@link AppointmentApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppointmentApplication.class).web(true).run(args);
    }
}