package de.msg;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;

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