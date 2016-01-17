package de.msg.model;

@Deprecated
public class CarMaintenance 
{
	
	private long timestamp;
	private long car;
	private String sensorName;
	private String sensorValue;
	private long appointment;
	
	public CarMaintenance() {
		super();
	}
	
	public CarMaintenance(long timestamp, long car, String sensorName, String sensorValue, long appointment) {
		super();
		this.timestamp = timestamp;
		this.car = car;
		this.sensorName = sensorName;
		this.sensorValue = sensorValue;
		this.appointment = appointment;
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

	public long getAppointment() {
		return appointment;
	}

	public void setAppointment(long appointment) {
		this.appointment = appointment;
	}

}
