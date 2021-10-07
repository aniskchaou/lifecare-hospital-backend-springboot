package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Patient;
import com.dev.delta.exceptions.PatientNotFoundException;
import com.dev.delta.repositories.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	
	public Patient addPatient(Patient patient)
	{
		return patientRepository.save(patient);
	}
	
	public List<Patient> findAll()
	{
		return patientRepository.findAll();
	}
	
	
	public Patient updatePatient(Patient patient)
	{
		return patientRepository.save(patient);
	}
	
	public Patient findPatientById(Long id) 
	{
		
		return patientRepository
				.findById(id)
				.orElseThrow(()->new PatientNotFoundException("Patient is not found"));
	}
	
	public void deletePatient(Long id)
	{
		patientRepository.deleteById(id);
	}
}
