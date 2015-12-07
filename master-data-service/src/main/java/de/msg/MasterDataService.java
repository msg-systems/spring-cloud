package de.msg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MasterDataService {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MasterDataService.class).web(true).run(args);
    }
    private Integer random = new Random().nextInt();

    @RequestMapping("/")
    public String home() {
        return "Hello world: " + random;
    }
}