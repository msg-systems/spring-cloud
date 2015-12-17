package de.msg.domain.carmaintenance;



public class CarMaintenance {
    private long timestamp;
    private long car;
    private String sensorName;
    private String sensorValue;

    

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
