package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VaccinatedPeople {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String patient;
	@ManyToOne
	@JoinColumn(name="vaccine_id")
	Vaccination vaccine; 
	String serialNo;
	String doseNo;
	String date;
	String note;
	
	public VaccinatedPeople() {
		// TODO Auto-generated constructor stub
	}

	public VaccinatedPeople(String patient, Vaccination vaccine, String serialNo, String doseNo, String date,
			String note) {
		super();
		this.patient = patient;
		this.vaccine = vaccine;
		this.serialNo = serialNo;
		this.doseNo = doseNo;
		this.date = date;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public Vaccination getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccination vaccine) {
		this.vaccine = vaccine;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getDoseNo() {
		return doseNo;
	}

	public void setDoseNo(String doseNo) {
		this.doseNo = doseNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
