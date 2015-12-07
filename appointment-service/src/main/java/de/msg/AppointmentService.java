package de.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class AppointmentService {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppointmentService.class).web(true).run(args);
    }

    @RequestMapping("/")
    public String home() {
        String exchange = this.restTemplate.getForObject("http://master-data-service/", String.class);

        System.out.println(exchange);

        return exchange;
    }

    // Fängt Maintanance Events.
    // Customer getCustomer(Long carId)
    // List<Appointment> createAppointment(MaintainanceEvent) for Customer
    // List<Appointment> createAppointment(MaintainanceEvent) for ServiceCenter (Werkstatt)
    // confirmAppointment(Appointment) for Customer
    // confirmAppointment(Appointment) for ServiceCenter (Werkstatt)
}