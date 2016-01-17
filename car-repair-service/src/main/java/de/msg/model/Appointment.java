package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne
    private Customer customer;
    @OneToOne
    private ServiceCenter serviceCenter;
    private long moment;

    /**
     * Custom constructor
     *
     * @param customer      The {@link Customer}
     * @param serviceCenter The {@link ServiceCenter}
     * @param moment        The moment when the {@link Appointment} is scheduled
     */
    public Appointment(Customer customer, ServiceCenter serviceCenter, long moment) {
        this.customer = customer;
        this.serviceCenter = serviceCenter;
        this.moment = moment;
    }
}
