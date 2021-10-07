package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class BedType {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String bedType;
	String Description;
	
	public BedType() {
		// TODO Auto-generated constructor stub
	}

	public BedType(String bedType, String description) {
		super();
		this.bedType = bedType;
		Description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
