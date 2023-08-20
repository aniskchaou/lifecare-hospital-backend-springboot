package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.RecipionistRepository;

@Service
public class RecipionistDTO implements DTO{

	@Autowired
	RecipionistRepository recipionistRepository;

	@Override
	public void populate() {
		recipionistRepository.save(recipionist);
		
	}
	
}
