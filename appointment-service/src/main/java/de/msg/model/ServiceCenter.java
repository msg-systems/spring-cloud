package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@link ServiceCenter} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServiceCenter {
    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String email;
}
