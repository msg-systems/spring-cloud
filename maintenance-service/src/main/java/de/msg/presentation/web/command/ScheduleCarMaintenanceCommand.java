package de.msg.presentation.web.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import de.msg.domain.carmaintenance.CarMaintenance;
import de.msg.domain.carsensor.CarSensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This {@link HystrixCommand} schedules a {@link CarMaintenance} at car-repair-service. In more sophisticated scenarios you would use
 * a messaging middleware like ActiveMQ, RabbitMQ or Apache Kafka. Transferring the whole {@link CarSensor} is not wise due
 * performance issues.
 * See <a href="http://activemq.apache.org/">http://activemq.apache.org</a>
 * See <a href="https://www.rabbitmq.com/">https://www.rabbitmq.com/</a>
 * See <a href="http://kafka.apache.org/">http://kafka.apache.org/</a>
 */
@Component
public class ScheduleCarMaintenanceCommand {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Schedules the {@link CarMaintenance} event at car-repair-service.
     *
     * @param event The {@link CarMaintenance} to schedule.
     * @return The scheduled {@link CarMaintenance}.
     */
    @HystrixCommand
    public CarMaintenance scheduleCarMaintenanceCommand(CarMaintenance carMaintenance) {
        return restTemplate.postForObject("http://appointment-service/scheduleCarMaintenance/", carMaintenance, CarMaintenance.class);
    }
}
