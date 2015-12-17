package de.msg.domain.customer;

public class Customer {
    
	private String forName;
    private String surName;
    private long carId;
    private String contact;
    
    
	public Customer() {
		super();
	}
	public Customer(String forName, String surName, long carId, String contact) {
		super();
		this.forName = forName;
		this.surName = surName;
		this.carId = carId;
		this.contact = contact;
	}
	public String getForName() {
		return forName;
	}
	public void setForName(String forName) {
		this.forName = forName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
