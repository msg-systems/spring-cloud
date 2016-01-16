package de.msg.repository;

import de.msg.model.SensorEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * An simple {@link MongoRepository} to persist {@link SensorEvent} data. In more sophisticated scenarios you would use a NoSQL database like Apache Cassandra.
 * See <a href="http://cassandra.apache.org/">http://cassandra.apache.org</a>
 */
@RepositoryRestResource
public interface SensorEventRepository extends MongoRepository<SensorEvent, String> {
}
