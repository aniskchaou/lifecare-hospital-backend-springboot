package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.DoctorRepository;

@Service
public class DoctorDTO implements DTO{

	@Autowired
	DoctorRepository doctorRepository;
	@Override
	public void populate() {
		doctor.setBlood_group("");
		doctor.setFirstname("sdfsdg");
		
		doctorRepository.save(doctor);
		
	}

}
