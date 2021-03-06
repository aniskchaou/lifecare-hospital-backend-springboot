package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="lifecare_departement")
public class Departement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	  Long id;
	String  name;
	String    description;
	String    status;
	
	
	public Departement() {
		// TODO Auto-generated constructor stub
	}


	public Departement(String name, String description, String status) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
