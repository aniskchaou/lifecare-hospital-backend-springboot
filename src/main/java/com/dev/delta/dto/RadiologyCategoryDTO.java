package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.RadiologyCategoryRepository;

@Service
public class RadiologyCategoryDTO implements DTO{

	@Autowired
	RadiologyCategoryRepository  radiologyCategoryRepository;

	@Override
	public void populate() {
		radiologyCategory.setName("");
		radiologyCategoryRepository.save(radiologyCategory);
		
	}
	
}
