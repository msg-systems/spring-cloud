package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * {@link CarMaintenanceEvent} is an entity for scheduling an car maintenance if reburied.
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

    /**
     * Creates a {@link CarMaintenanceEvent} from {@link CarSensorData}.
     *
     * @param data The {@link CarSensorData}
     */
    public CarMaintenanceEvent(CarSensorData data) {
        this.timestamp = data.getTimestamp();
        this.car = data.getCar();
        this.sensorName = data.getSensorName();
        this.sensorValue = data.getSensorValue();
    }
}
