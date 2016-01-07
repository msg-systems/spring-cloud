package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * {@link SensorValue} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class SensorValue {
    @Id
    private String id;
    @NotNull
    private long timestamp;
    @NotNull
    private long car;
    @NotNull
    private String sensorName;
    @NotNull
    private String sensorValue;

    /**
     * Custom constructor of {@link SensorValue}.
     *
     * @param timestamp   The timestamp as UTC long value
     * @param car         The id of the car
     * @param sensorName  The name of the sensor
     * @param sensorValue The value of the sensor
     */
    public SensorValue(long timestamp, long car, String sensorName, String sensorValue) {
        this.timestamp = timestamp;
        this.car = car;
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
    }
}
