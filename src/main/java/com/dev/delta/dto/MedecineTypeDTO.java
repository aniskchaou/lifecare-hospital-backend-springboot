package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.MedecineTypeRepository;

@Service
public class MedecineTypeDTO implements DTO{

	@Autowired
	MedecineTypeRepository medecineTypeRepository;
	
	@Override
	public void populate() {
		medecineType.setName("");
		medecineTypeRepository.save(medecineType);
	}

	
}
