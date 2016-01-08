package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's
 * {@link org.springframework.context.ApplicationContext} and generates some
 * simple example test data.
 *
 * @author Rafael Kansy, Micahel Schäfer
 */
@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableEurekaClient
@EnableFeignClients
public class DataCollectionApplication {

    /**
     * Main method as entry point of {@link DataCollectionApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(DataCollectionApplication.class).web(true).run(args);
    }
}