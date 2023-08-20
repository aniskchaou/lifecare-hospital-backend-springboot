package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.DiagnosisRepository;

@Service
public class DiagnosisDTO implements DTO{

	@Autowired
	DiagnosisRepository diagnosisRepository;
	
	@Override
	public void populate() {
		diagnosis.setAge("");
		diagnosis.setAverageglucose("");
		diagnosis.setBloodPressure("");
		diagnosis.setCholesterol("");
		diagnosis.setDiabetes("");
		diagnosis.setDiagnosisCategory("");
		diagnosis.setDoctor(doctor);
		diagnosis.setFastingBloodSugar("");
		diagnosis.setHeight("");
		diagnosis.setPatientHospital(patient);
		diagnosis.setReportNumber("");
		diagnosis.setUrineSugar("");
		diagnosis.setWeight("");
		diagnosisRepository.save(diagnosis);
	}

}
