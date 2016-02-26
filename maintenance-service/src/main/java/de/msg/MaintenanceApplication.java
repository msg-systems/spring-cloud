package de.msg;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.hal.Jackson2HalModule;

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

    /**
     * Registers {@link Jackson2HalModule} at the {@link ObjectMapper}.
     *
     * @param objectMapper The {@link ObjectMapper} to register the {@link Jackson2HalModule}
     * @return An {@link ObjectMapper} with {@link Jackson2HalModule} support
     */
    // TODO Using JSON HAL with Feign client needs maybe refactoring http://stackoverflow.com/questions/30515483/feign-and-hal-resources
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    @Autowired
    public ObjectMapper configureObjectMapper(ObjectMapper objectMapper) {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.registerModule(new Jackson2HalModule());
        return objectMapper;
    }
}