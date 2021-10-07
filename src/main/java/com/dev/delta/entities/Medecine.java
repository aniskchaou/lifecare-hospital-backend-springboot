package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Medecine {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String Manufacture;
	@ManyToOne
	@JoinColumn(name="medecine_category_id")
	MedecineCategory category;
	@ManyToOne
	@JoinColumn(name="medecine_type_id")
	MedecineType type;
	String name;
	String quantity;
	String price;
	String expireDate;
	String description;
	
	public Medecine() {
		// TODO Auto-generated constructor stub
	}

	public Medecine(String manufacture, MedecineCategory category, MedecineType type, String name, String quantity,
			String price, String expireDate, String description) {
		super();
		Manufacture = manufacture;
		this.category = category;
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.expireDate = expireDate;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacture() {
		return Manufacture;
	}

	public void setManufacture(String manufacture) {
		Manufacture = manufacture;
	}

	public MedecineCategory getCategory() {
		return category;
	}

	public void setCategory(MedecineCategory category) {
		this.category = category;
	}

	public MedecineType getType() {
		return type;
	}

	public void setType(MedecineType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
