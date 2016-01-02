package de.msg;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A simple {@link SpringBootApplication} bootstraps Spring's {@link org.springframework.context.ApplicationContext}.
 * The {@link HystrixDashboardApplication} provides the Hystrix dashboard.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableHystrixDashboard
@Controller
public class HystrixDashboardApplication {
    /**
     * Forwards http requests from / to /hystrix.
     *
     * @return Request mapping to /hystrix.
     */
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

    /**
     * Main method as entry point of {@link HystrixDashboardApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
    }
}
