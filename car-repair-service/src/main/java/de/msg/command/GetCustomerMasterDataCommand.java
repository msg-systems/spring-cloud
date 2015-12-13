package de.msg.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.msg.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This {@link HystrixCommand} fetches master-data record for an specific car.
 */
@Component
public class GetCustomerMasterDataCommand {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches the {@link Customer} from master-data-service matching the car with id <code>carId</code>.
     *
     * @return The {@link Customer} from master-data-service matching the car with id <code>carId</code>.
     */
    // TODO RK provide carId
    @HystrixCommand
    public Customer getCustomer(long carId) {
        return restTemplate.getForObject("http://master-data-service/car", Customer.class);
    }
}
