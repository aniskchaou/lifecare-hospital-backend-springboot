package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Diagnosis {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="patient_id")
	Patient patientHospital  ;
	@ManyToOne
	@JoinColumn(name="doctor_id")
	Doctor doctor ;
	String DiagnosisCategory;
	String ReportNumber;
	String Age;
	String Height;
	String Weight;
	String Averageglucose;
	String FastingBloodSugar;
	String UrineSugar;
	String BloodPressure;
	String Diabetes;
	String Cholesterol;
	
	public Diagnosis() {
		// TODO Auto-generated constructor stub
	}

	public Diagnosis(Patient patientHospital, Doctor doctor, String diagnosisCategory, String reportNumber,
			String age, String height, String weight, String averageglucose, String fastingBloodSugar,
			String urineSugar, String bloodPressure, String diabetes, String cholesterol) {
		super();
		this.patientHospital = patientHospital;
		this.doctor = doctor;
		DiagnosisCategory = diagnosisCategory;
		ReportNumber = reportNumber;
		Age = age;
		Height = height;
		Weight = weight;
		Averageglucose = averageglucose;
		FastingBloodSugar = fastingBloodSugar;
		UrineSugar = urineSugar;
		BloodPressure = bloodPressure;
		Diabetes = diabetes;
		Cholesterol = cholesterol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatientHospital() {
		return patientHospital;
	}

	public void setPatientHospital(Patient patientHospital) {
		this.patientHospital = patientHospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDiagnosisCategory() {
		return DiagnosisCategory;
	}

	public void setDiagnosisCategory(String diagnosisCategory) {
		DiagnosisCategory = diagnosisCategory;
	}

	public String getReportNumber() {
		return ReportNumber;
	}

	public void setReportNumber(String reportNumber) {
		ReportNumber = reportNumber;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getHeight() {
		return Height;
	}

	public void setHeight(String height) {
		Height = height;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getAverageglucose() {
		return Averageglucose;
	}

	public void setAverageglucose(String averageglucose) {
		Averageglucose = averageglucose;
	}

	public String getFastingBloodSugar() {
		return FastingBloodSugar;
	}

	public void setFastingBloodSugar(String fastingBloodSugar) {
		FastingBloodSugar = fastingBloodSugar;
	}

	public String getUrineSugar() {
		return UrineSugar;
	}

	public void setUrineSugar(String urineSugar) {
		UrineSugar = urineSugar;
	}

	public String getBloodPressure() {
		return BloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		BloodPressure = bloodPressure;
	}

	public String getDiabetes() {
		return Diabetes;
	}

	public void setDiabetes(String diabetes) {
		Diabetes = diabetes;
	}

	public String getCholesterol() {
		return Cholesterol;
	}

	public void setCholesterol(String cholesterol) {
		Cholesterol = cholesterol;
	}
	
	
	
}
