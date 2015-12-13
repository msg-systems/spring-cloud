package de.msg.controller;

import de.msg.model.CarSensorData;
import de.msg.repository.SimpleCarSensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link CarSensorDataController} is a {@link RestController} providing sensorData to other services, like maintenance-service.
 */
@RestController
public class CarSensorDataController {
    @Autowired
    private SimpleCarSensorDataRepository repository;

    /**
     * Returns all {@link CarSensorData} as JSON encoded array.
     *
     * @return All {@link CarSensorData} as JSON encoded array.
     */
    @RequestMapping("/sensorData")
    public CarSensorData[] sensorData() {
        return repository.findAll();
    }
}
