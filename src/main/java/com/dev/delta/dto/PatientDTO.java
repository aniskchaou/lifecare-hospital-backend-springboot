package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Patient;
import com.dev.delta.repositories.PatientRepository;

@Service
public class PatientDTO implements DTO {

	@Autowired
	PatientRepository patientRepository;
	@Override
	public void populate() {
		patientRepository.save(new Patient("zer", "zer", "zer", "zer", "er", "zer", "zer", "er", "zer", "zer", "zer"));
		
		
	}

}
