package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link ZuulProxyApplication} provides Zuul proxy and an API Gateway.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulProxyApplication {
    /**
     * Main method as entry point of {@link ZuulProxyApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulProxyApplication.class).web(true).run(args);
    }
}
