package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="lifecare_appointement")
public class Appointement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="departement_id")
	Departement  departement_id;
	@ManyToOne
	@JoinColumn(name="patient_id")
	Patient    patient_id;
	@ManyToOne
	@JoinColumn(name="doctor_id")
	Doctor   doctor_id;
	String   date;
	String   problem;
	String   status;
	
	
	
	
	public Appointement(Departement departement_id, Patient patient_id, Doctor doctor_id, String date, String problem,
			String status) {
		super();
		this.departement_id = departement_id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.date = date;
		this.problem = problem;
		this.status = status;
	}

	public Appointement() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public Departement getDepartement_id() {
		return departement_id;
	}

	public void setDepartement_id(Departement departement_id) {
		this.departement_id = departement_id;
	}

	public Patient getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public Doctor getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
