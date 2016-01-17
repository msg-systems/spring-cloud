package de.msg.web;

import de.msg.model.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * {@link FeignClient} communicating with <tt>master-data-service</tt>.
 */
@FeignClient(value = "master-data-service")
public interface MasterDataCustomerServiceClient {
    /**
     * Finds {@link Customer} by car identifier.
     *
     * @param car The car
     * @return The {@link Customer} instances.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/customers/search/findByCar/", consumes = "application/json")
    Set<PagedResources<Customer>> findByCar(@RequestParam("car") long car);
}
