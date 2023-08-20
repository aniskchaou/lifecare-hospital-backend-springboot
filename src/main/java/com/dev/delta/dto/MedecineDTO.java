package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.MedecineCategoryRepository;

@Service
public class MedecineDTO implements DTO{

	@Autowired
	MedecineCategoryRepository medecineCategoryRepository;
	
	@Override
	public void populate() {
		medecine.setCategory(medecineCategory);
		medecine.setDescription("");
		medecine.setExpireDate("");
		medecine.setManufacture("");
		medecine.setName("");
		medecine.setPrice("");
		medecine.setQuantity("");
		medecine.setType(medecineType);
		medecineCategoryRepository.save(medecineCategory);
	}

	
}
