package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * {@link CarMaintenanceEvent} is an entity for scheduling an car maintenance if required.
 * Lombok project provides constructors and  various methods like {@link lombok.Getter} {@link lombok.Setter}
 * by using {@link Data} annotation.
 */
@Data
@AllArgsConstructor
public class CarMaintenanceEvent {
    private long timestamp;
    private long car;
    private String sensorName;
    private String sensorValue;
    private long appointment;
}
