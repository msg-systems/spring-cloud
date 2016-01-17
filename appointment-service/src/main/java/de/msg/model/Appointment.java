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
}
