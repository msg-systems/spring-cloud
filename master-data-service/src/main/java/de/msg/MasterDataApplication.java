package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link MasterDataApplication} provides master-data for i.e {@link de.msg.model.Customer}.
 */
@SpringBootApplication
@EnableEurekaClient
public class MasterDataApplication {

    /**
     * Main method as entry point of {@link MasterDataApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(MasterDataApplication.class).web(true).run(args);
    }
}