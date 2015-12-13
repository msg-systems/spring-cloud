package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * {@link CarSensorData} is an entity for storing senor data provided by various sensors.
 * Lombok project provides constructors and  various methods like {@link lombok.Getter} {@link lombok.Setter}
 * by using {@link Data} annotation.
 */
@Data
@AllArgsConstructor
public class CarSensorData {
    private long timestamp;
    private long car;
    private String sensorName;
    private String sensorValue;
}
