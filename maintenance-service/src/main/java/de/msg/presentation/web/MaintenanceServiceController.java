package de.msg.presentation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.msg.domain.carmaintenance.CarMaintenance;
import de.msg.domain.carsensor.CarSensor;
import de.msg.domain.service.MaintenanceService;
import de.msg.presentation.web.command.GetCarSensorCommand;
import de.msg.presentation.web.command.ScheduleCarMaintenanceCommand;

/**
 * The {@link MaintenanceServiceController} is a {@link RestController} evaluating maintenance of a car.
 * If maintenance is required an {@link CarSensor} is generated and sent to car-repair-service.
 */
@RestController
public class MaintenanceServiceController {
	
	@Autowired
    private GetCarSensorCommand getCarSensorCommand;
	
    @Autowired
    private ScheduleCarMaintenanceCommand scheduleCarMaintenanceCommand;
	
	
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceService service;

    /**
     * Evaluates if maintenance is required.
     *
     * @return All {@link CarSensor} indicating car maintenance.
     */
    @RequestMapping("/")
    public CarSensor[] home() {
    	
    	 // Fetch all CarSensor instances 
    	CarSensor[] carSensor = getCarSensorCommand.getCarSenor();
    
    	// Calculate the maintenance depends on maintenance rules 
    	CarSensor[] result = service.evaluateMaintenance(carSensor);
  
    	// If the result contains a car sensor which fulfilled the rule schedule a car maintenance  
        if (result.length > 0) {
       	 	
            CarMaintenance carMaintenance = new CarMaintenance(result[0]);
            scheduleCarMaintenanceCommand.scheduleCarMaintenanceCommand(carMaintenance);
            return result;
        } else {
            return new CarSensor[0];
        }
    }
}
