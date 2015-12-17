package de.msg.domain.customer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.msg.domain.customer.Customer;



/**
 * The {@link CustomerController} provides master-data records for {@link de.msg.domain.Customer} entities.
 */
@RestController
public class CustomerController {

    /**
     * Returns the {@link Customer} related to a <code>carId</code>.
     *
     * @return The {@link Customer}
     */
    // TODO RK use carId
    @RequestMapping("/car")
    public Customer home() {
        return new Customer("John", "Smith", 1L, "john.smith@email.com");
    }
}
