package de.msg.domain.carsensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CarSensor {
    private long timestamp;
    private long car;
    private String sensorName;
    private String sensorValue;
    
    
    public CarSensor() {
		super();
	}
    
    public CarSensor(long timestamp, long car, String sensorName, String sensorValue) {
		super();
		this.timestamp = timestamp;
		this.car = car;
		this.sensorName = sensorName;
		this.sensorValue = sensorValue;
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
