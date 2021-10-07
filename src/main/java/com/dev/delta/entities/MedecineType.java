package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MedecineType {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	
	public MedecineType() {
		// TODO Auto-generated constructor stub
	}

	public MedecineType(Long id, String name) {
		super();
		this.id = id;
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
