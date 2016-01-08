package de.msg.repository;

import de.msg.model.SensorEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * An simple {@link MongoRepository} to persist {@link SensorEvent} data. In more sophisticated scenarios you would use a NoSQL database like Apache Cassandra.
 * See <a href="http://cassandra.apache.org/">http://cassandra.apache.org</a>
 */
@RepositoryRestResource
public interface SensorEventRepository extends MongoRepository<SensorEvent, String> {

    /**
     * Finds {@link SensorEvent} entities by <tt>car</tt> <tt>sensorName</tt> and <tt>sensorValue</tt>.
     *
     * @param car         The id of the car
     * @param sensorName  The name of the sensor
     * @param sensorValue The value of the sensor
     * @return The {@link SensorEvent}
     */
    SensorEvent findByCarAndSensorNameAndSensorValue(long car, String sensorName, String sensorValue);

    @Query("select coalesce(max(c.car), '0') from Car c")
    long getMaxCar();
}
