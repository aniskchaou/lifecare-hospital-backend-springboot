package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.RadiologyTypeRepository;

@Service
public class RadiologyTypeDTO implements DTO {

	@Autowired
	RadiologyTypeRepository radiologyTypeRepository;

	@Override
	public void populate() {
		radiologyType.setDescription("");
		radiologyType.setName("");
		radiologyTypeRepository.save(radiologyType);
		
	}
	
	
	
}
