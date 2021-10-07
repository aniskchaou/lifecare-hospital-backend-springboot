package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Radiology {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String testName;
	@ManyToOne
	@JoinColumn(name="radiology_type_id")
	RadiologyType radiologyType;
	@ManyToOne
	@JoinColumn(name="radiology_category_id")
	RadiologyCategory name;
	String reportDays;
	String standardCharge;
	
	public Radiology() {
		// TODO Auto-generated constructor stub
	}

	public Radiology(String testName, RadiologyType radiologyType, RadiologyCategory name, String reportDays,
			String standardCharge) {
		super();
		this.testName = testName;
		this.radiologyType = radiologyType;
		this.name = name;
		this.reportDays = reportDays;
		this.standardCharge = standardCharge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public RadiologyType getRadiologyType() {
		return radiologyType;
	}

	public void setRadiologyType(RadiologyType radiologyType) {
		this.radiologyType = radiologyType;
	}

	public RadiologyCategory getName() {
		return name;
	}

	public void setName(RadiologyCategory name) {
		this.name = name;
	}

	public String getReportDays() {
		return reportDays;
	}

	public void setReportDays(String reportDays) {
		this.reportDays = reportDays;
	}

	public String getStandardCharge() {
		return standardCharge;
	}

	public void setStandardCharge(String standardCharge) {
		this.standardCharge = standardCharge;
	}
	
	
	
}
