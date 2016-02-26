package de.msg.web;

import de.msg.model.ServiceCenter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * {@link FeignClient} communicating with <tt>master-data-service</tt>.
 */
@FeignClient(value = "master-data-service")
public interface MasterDataServiceCenterServiceClient {
    /**
     * Finds {@link ServiceCenter} by car identifier.
     *
     * @return The {@link ServiceCenter} instances.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/serviceCenters", consumes = "application/json")
    Set<PagedResources<ServiceCenter>> findAll();
}
