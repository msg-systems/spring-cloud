package de.msg.controller;

import de.msg.model.CarSensorData;
import de.msg.repository.SimpleCarSensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * The {@link CarSensorDataController} is a {@link RestController} providing sensorData to other services, like maintenance-service.
 */
@RestController
public class CarSensorDataController {
    @Autowired
    private SimpleCarSensorDataRepository repository;

    /**
     * Returns all {@link CarSensorData} as JSON encoded objects.
     *
     * @return All {@link CarSensorData} as JSON encoded objects.
     */
    @RequestMapping("/sensorData")
    public Set<CarSensorData> sensorData() {
        return repository.findAll();
    }
}
