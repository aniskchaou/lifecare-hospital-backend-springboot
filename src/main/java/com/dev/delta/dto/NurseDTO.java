package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.NurseRepository;

@Service
public class NurseDTO implements DTO{

	@Autowired
	NurseRepository nurseRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		nurse.setLastName("");
		nurseRepository.save(nurse);
	}

	
}
