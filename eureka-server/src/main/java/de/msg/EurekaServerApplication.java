package de.msg;

import org.springframework.boot.builder.SpringApplicationBuilder;


public class EurekaServerApplication {
    /**
     * Main method as entry point of {@link EurekaServerApplication}.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerConfiguration.class).web(true).run(args);
    }
}