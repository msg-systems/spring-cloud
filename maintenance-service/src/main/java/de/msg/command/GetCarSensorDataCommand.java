package de.msg.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.msg.model.CarSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This {@link HystrixCommand} fetches {@link CarSensorData} from data-collection-service. In more sophisticated scenarios you would use
 * a messaging middleware like ActiveMQ, RabbitMQ or Apache Kafka. Transferring the whole {@link CarSensorData} is not wise due
 * performance issues.
 * See <a href="http://activemq.apache.org/" />
 * See <a href="https://www.rabbitmq.com/" />
 * See <a href="http://kafka.apache.org/" />
 */
@Component
public class GetCarSensorDataCommand {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches all {@link CarSensorData} from data-collection-service.
     *
     * @return All {@link CarSensorData} encoded as JSON array.
     */
    @HystrixCommand
    public CarSensorData[] getSensorData() {
        return restTemplate.getForObject("http://data-collection-service/sensorData", CarSensorData[].class);
    }
}
