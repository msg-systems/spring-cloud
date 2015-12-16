package de.msg.repository;

import de.msg.model.CarSensorData;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Used to emulate persistence by a simple in memory repository. In more sophisticated scenarios you would use a NoSQL database like Apache Cassandra.
 * See <a href="http://cassandra.apache.org/">http://cassandra.apache.org</a>
 */
@Component
public class SimpleCarSensorDataRepository {
    private final Set<CarSensorData> entities = new HashSet<>();

    /**
     * Emulates a save operation on the {@link SimpleCarSensorDataRepository}.
     *
     * @param entities A {@link Collection} of all {@link CarSensorData} entities to save.
     */
    public void save(Collection<CarSensorData> entities) {
        this.entities.addAll(entities);
    }

    /**
     * Emulates a findAll operation on the {@link SimpleCarSensorDataRepository}.
     *
     * @return A array of all {@link CarSensorData} entities.
     */
    public CarSensorData[] findAll() {
        return this.entities.toArray(new CarSensorData[entities.size()]);
    }
}
