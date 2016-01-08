package de.msg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link MaintenanceEvent} domain entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MaintenanceEvent {
    @Id
    private String id;
    @NotNull
    private long timestamp;
    @NotNull
    private long car;
    @NotNull
    private String sensorName;
    @NotNull
    private String sensorValueThreshold;
    private Set<SensorEvent> sensorEvents = new HashSet<>();

    /**
     * Custom constructor of {@link MaintenanceEvent}.
     *
     * @param timestamp            The timestamp as UTC long value
     * @param car                  The id of the car
     * @param sensorName           The name of the sensor
     * @param sensorValueThreshold The value of the sensor
     * @param sensorEvents         A {@link Set} of {@link SensorEvent} instances
     */
    public MaintenanceEvent(long timestamp, long car, String sensorName, String sensorValueThreshold, Set<SensorEvent> sensorEvents) {
        this.timestamp = timestamp;
        this.car = car;
        this.sensorName = sensorName;
        this.sensorValueThreshold = sensorValueThreshold;
        this.sensorEvents = sensorEvents;
    }

    /**
     * Factory method responsible to build an {@link MaintenanceEvent} from an {@link SensorEvent}.
     *
     * @param sensorEvent The {@link SensorEvent} to build the {@link MaintenanceEvent} from
     * @return The build {@link MaintenanceEvent}
     */
    public static MaintenanceEvent build(SensorEvent sensorEvent) {
        MaintenanceEvent result = new MaintenanceEvent();

        LocalDateTime now = LocalDateTime.now();
        result.timestamp = now.toInstant(ZoneOffset.UTC).toEpochMilli();

        result.car = sensorEvent.getCar();
        result.sensorName = sensorEvent.getSensorName();
        result.sensorValueThreshold = sensorEvent.getSensorValue();
        return result;
    }
}
