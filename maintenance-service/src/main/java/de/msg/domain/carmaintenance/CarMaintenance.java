package de.msg.domain.carmaintenance;

import de.msg.domain.carsensor.CarSensor;
import lombok.AllArgsConstructor;
import lombok.Data;


public class CarMaintenance {
    private long timestamp;
    private long car;
    private String sensorName;
    private String sensorValue;

    public CarMaintenance() {
		super();
	}
    
    /**
     * Creates a {@link CarMaintenance} from {@link CarSensor}.
     *
     * @param data The {@link CarSensor}
     */
    public CarMaintenance(CarSensor data) {
        this.timestamp = data.getTimestamp();
        this.car = data.getCar();
        this.sensorName = data.getSensorName();
        this.sensorValue = data.getSensorValue();
    }

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getCar() {
		return car;
	}

	public void setCar(long car) {
		this.car = car;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getSensorValue() {
		return sensorValue;
	}

	public void setSensorValue(String sensorValue) {
		this.sensorValue = sensorValue;
	}

	
    
    
}
