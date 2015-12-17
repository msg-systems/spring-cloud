package de.msg.presentation.web.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import de.msg.domain.carsensor.CarSensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This {@link HystrixCommand} fetches {@link CarSensor} from data-collection-service. In more sophisticated scenarios you would use
 * a messaging middleware like ActiveMQ, RabbitMQ or Apache Kafka. Transferring the whole {@link CarSensor} is not wise due
 * performance issues.
 * See <a href="http://activemq.apache.org/">http://activemq.apache.org</a>
 * See <a href="https://www.rabbitmq.com/">https://www.rabbitmq.com/</a>
 * See <a href="http://kafka.apache.org/">http://kafka.apache.org/</a>
 */
@Component
public class GetCarSensorCommand {
    
	@SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches all {@link CarSensor} from data-collection-service.
     *
     * @return All {@link CarSensor} encoded as JSON array.
     */
    @HystrixCommand
    public CarSensor[] getCarSenor() {
        return restTemplate.getForObject("http://data-collection-service/", CarSensor[].class);
    }
}
