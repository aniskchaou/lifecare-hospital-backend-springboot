package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="lifecare_service")
public class Service {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String  name;
	String   description;
	String   quantity;
	String   amount;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	String   status;
     
     public Service() {
		// TODO Auto-generated constructor stub
	}

	public Service(String name, String description, String quantity, String amount, String status) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.amount = amount;
		this.status = status;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
     
     
}
