package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * {@link SensorEvent} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorEvent {
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
}
