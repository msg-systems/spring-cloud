package de.msg.controller;

import de.msg.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link CustomerController} provides master-data records for {@link de.msg.model.Customer} entities.
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
