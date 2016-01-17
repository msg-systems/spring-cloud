package de.msg;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.msg.model.Customer;
import de.msg.model.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.hal.Jackson2HalModule;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link CarRepairApplication} fetches appointment proposals from appointment-service and tries to schedule
 * an appointment for an {@link Customer} in an {@link ServiceCenter} for car maintenance.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CarRepairApplication {

    /**
     * Main method as entry point of {@link CarRepairApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(CarRepairApplication.class).web(true).run(args);
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