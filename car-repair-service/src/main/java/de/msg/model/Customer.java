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
}
