package de.msg.repository;

import de.msg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * An simple {@link JpaRepository} to persist {@link Customer} data.
 */
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds {@link Customer} entities by <tt>car</tt>.
     *
     * @param car The id of the car
     * @return The {@link Customer} instances.
     */
    Customer findByCar(@Param("car") long car);
}
