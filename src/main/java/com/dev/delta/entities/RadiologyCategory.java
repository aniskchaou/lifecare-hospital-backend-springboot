package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class RadiologyCategory {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	
	public RadiologyCategory() {
		// TODO Auto-generated constructor stub
	}

	public RadiologyCategory(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
