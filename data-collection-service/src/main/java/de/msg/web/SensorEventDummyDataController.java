package de.msg.web;

import de.msg.model.SensorEvent;
import de.msg.repository.SensorEventInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * This {@link RestController} generates dummy {@link SensorEvent} data.
 */
@RestController
public class SensorEventDummyDataController {
    // stateful Controller - avoid this in production - due scaling issues. If you require to replicate cluster state use redis.
    private long car = 0;

    @Autowired
    private SensorEventInitializer initializer;

    /**
     * Generates dummy {@link SensorEvent} data.
     *
     * @return A {@link Set} of dummy {@link SensorEvent}
     */
    @RequestMapping(value = "/dummy-data", method = RequestMethod.GET)
    public Set<SensorEvent> dummyData() {
        car++;
        return initializer.generateTestData(car);
    }
}
