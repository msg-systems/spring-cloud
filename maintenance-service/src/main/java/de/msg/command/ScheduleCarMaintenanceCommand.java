package de.msg.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.msg.model.CarMaintenanceEvent;
import de.msg.model.CarSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This {@link HystrixCommand} schedules a {@link CarMaintenanceEvent} at car-repair-service. In more sophisticated scenarios you would use
 * a messaging middleware like ActiveMQ, RabbitMQ or Apache Kafka. Transferring the whole {@link CarSensorData} is not wise due
 * performance issues.
 * See <a href="http://activemq.apache.org/" />
 * See <a href="https://www.rabbitmq.com/" />
 * See <a href="http://kafka.apache.org/" />
 */
@Component
public class ScheduleCarMaintenanceCommand {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Schedules the {@link CarMaintenanceEvent} event at car-repair-service.
     *
     * @param event The {@link CarMaintenanceEvent} to schedule.
     * @return The scheduled {@link CarMaintenanceEvent}.
     */
    @HystrixCommand
    public CarMaintenanceEvent scheduleCarMaintenanceCommand(CarMaintenanceEvent event) {
        //TODO MS communication with car-repair-service throws java.lang.RuntimeException: Not implemented due required Ribbon dependency.
        return restTemplate.postForObject("http://car-repair-service/", event, CarMaintenanceEvent.class);
    }
}
