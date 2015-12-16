package de.msg.presentation.web;

import de.msg.domain.carsenor.CarSensor;
import de.msg.domain.carsenor.CarSensorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link CarSensorController} is a {@link RestController} providing sensorData to other services, like maintenance-service.
 */
@RestController
public class CarSensorController {
    
	@Autowired
    private CarSensorRepository repository;

    /**
     * Returns all {@link CarSensor} as JSON encoded array.
     *
     * @return All {@link CarSensor} as JSON encoded array.
     */
    @RequestMapping("/sensorData")
    public ResponseEntity<CarSensor[]> getAll() {
    	return new ResponseEntity<CarSensor[]>(repository.findAll(),HttpStatus.OK);
    }
}
