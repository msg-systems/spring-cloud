package de.msg.domain.carsenor;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * 
 * @author Rafael Kansy, Michael Schäfer 
 * */
/**
 * Used to emulate persistence by a simple in memory repository. In more sophisticated scenarios you would use a NoSQL database like Apache Cassandra.
 * See <a href="http://cassandra.apache.org/">http://cassandra.apache.org</a>
 */
@Component
public class CarSensorRepository {
    private final Set<CarSensor> entities = new HashSet<>();

    /**
     * Emulates a save operation on the {@link CarSensorRepository}.
     *
     * @param entities A {@link Collection} of all {@link CarSensor} entities to save.
     */
    public void save(Collection<CarSensor> entities) {
        this.entities.addAll(entities);
    }

    /**
     * Emulates a findAll operation on the {@link CarSensorRepository}.
     *
     * @return A array of all {@link CarSensor} entities.
     */
    public CarSensor[] findAll() {
        return this.entities.toArray(new CarSensor[entities.size()]);
    }
}
