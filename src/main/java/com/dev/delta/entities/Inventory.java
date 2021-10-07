package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Inventory {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String itemCategory;
	String unit;
	String description;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(String name, String itemCategory, String unit, String description) {
		super();
		this.name = name;
		this.itemCategory = itemCategory;
		this.unit = unit;
		this.description = description;
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

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
