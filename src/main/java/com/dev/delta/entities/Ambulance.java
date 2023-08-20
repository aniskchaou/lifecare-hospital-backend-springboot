package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ambulance {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String vehicleNumber;
	String model;
	String year;
	@ManyToOne
	@JoinColumn(name="driver")
	Driver driver;
	String note;
	
	public Ambulance() {
		// TODO Auto-generated constructor stub
	}

	public Ambulance(String vehicleNumber, String model, String year, Driver driver, String note) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.year = year;
		this.driver = driver;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
