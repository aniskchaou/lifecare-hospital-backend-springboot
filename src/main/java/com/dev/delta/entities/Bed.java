package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Bed {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String bedNumber;
	@ManyToOne
	@JoinColumn(name="bed_type_id")
	BedType bedType;
	String floor ;
	
	public Bed() {
		// TODO Auto-generated constructor stub
	}

	public Bed(String bedNumber, BedType bedType, String floor) {
		super();
		this.bedNumber = bedNumber;
		this.bedType = bedType;
		this.floor = floor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public BedType getBedType() {
		return bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	
}
