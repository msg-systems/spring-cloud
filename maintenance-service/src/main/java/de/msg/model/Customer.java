package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link Customer} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private long id;
	private String firstName;
	private String lastName;
	private long car;
	private String email;
}
