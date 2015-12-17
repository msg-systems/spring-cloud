package de.msg;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;


public class HystrixDashboardApplication {
   

    /**
     * Main method as entry point of {@link HystrixDashboardApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardConfiguration.class).web(true).run(args);
    }
}
