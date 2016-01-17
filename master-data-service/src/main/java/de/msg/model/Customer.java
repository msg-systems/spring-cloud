package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@link Customer} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private long car;
    private String email;

    /**
     * Custom constructor of {@link Customer}
     *
     * @param firstName The firstName of the {@link Customer}
     * @param lastName  The lastName of the {@link Customer}
     * @param car       The identifier of the {@link Customer}
     * @param email     The email of the {@link Customer}
     */
    public Customer(String firstName, String lastName, long car, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
        this.email = email;
    }
}
