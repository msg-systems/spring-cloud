package de.msg.repository;

import com.mongodb.DBObject;
import de.msg.web.MaintenanceServiceClient;
import de.msg.model.SensorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.MongoMappingEvent;
import org.springframework.stereotype.Component;

/**
 * The {@link SensorEventRepositoryEventListener} catches {@link MongoMappingEvent}s. The caught {@link SensorEvent} will be posted to
 * <tt>maintenance-service</tt> to evaluate if a maintenance is required.
 */
@Component
public class SensorEventRepositoryEventListener extends AbstractMongoEventListener<SensorEvent> {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceServiceClient client;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAfterSave(SensorEvent source, DBObject dbo) {
        super.onAfterSave(source, dbo);
        client.evaluateSensorEvent(source);
    }
}
