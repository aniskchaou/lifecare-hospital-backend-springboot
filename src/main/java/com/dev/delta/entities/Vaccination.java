package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Vaccination {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String constractor;
	String commercialName;
	public Vaccination() {
		// TODO Auto-generated constructor stub
	}
	public Vaccination(String name, String constractor, String commercialName) {
		super();
		this.name = name;
		this.constractor = constractor;
		this.commercialName = commercialName;
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
	public String getConstractor() {
		return constractor;
	}
	public void setConstractor(String constractor) {
		this.constractor = constractor;
	}
	public String getCommercialName() {
		return commercialName;
	}
	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}
	
	
}
