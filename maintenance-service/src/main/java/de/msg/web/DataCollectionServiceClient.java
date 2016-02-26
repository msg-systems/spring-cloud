package de.msg.web;

import de.msg.model.SensorEvent;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * {@link FeignClient} communicating with <tt>data-collection-service</tt>.
 */
@FeignClient(value = "data-collection-service")
public interface DataCollectionServiceClient {
    /**
     * Finds {@link SensorEvent} by car identifier.
     *
     * @param car The car
     * @return A {@link Set} of {@link SensorEvent} instances.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/sensorEvents/search/findByCar/?car={car}", consumes = "application/json")
    Set<PagedResources<SensorEvent>> findByCar(@RequestParam("car") long car);
}
