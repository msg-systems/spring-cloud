package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link Customer} is an entity.
 * Lombok project provides constructors and  various methods like {@link lombok.Getter} {@link lombok.Setter}
 * by using {@link Data} annotation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String forName;
    private String surName;
    private long carId;
    private String contact;
}
