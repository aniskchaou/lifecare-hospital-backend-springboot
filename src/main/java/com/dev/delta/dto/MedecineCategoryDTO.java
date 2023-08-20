package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.MedecineCategoryRepository;

@Service
public class MedecineCategoryDTO implements DTO{

	@Autowired
	MedecineCategoryRepository   categoryRepository;
	
	@Override
	public void populate() {
		medecineCategory.setName("");
		categoryRepository.save(medecineCategory);
		
	}

}
