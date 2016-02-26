package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * {@link Appointment} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private long id;
    private long customer;
    private long serviceCenter;
    private long moment;

    /**
     * Custom constructor
     *
     * @param customer      The {@link Customer}
     * @param serviceCenter The {@link ServiceCenter}
     * @param moment        The moment when the {@link Appointment} is scheduled
     */
    public Appointment(Customer customer, ServiceCenter serviceCenter, long moment) {
        this.customer = customer.getId();
        this.serviceCenter = serviceCenter.getId();
        this.moment = moment;
    }
}
