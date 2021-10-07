package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.MedecineCategory;
import com.dev.delta.exceptions.MedecineCategoryNotFoundException;
import com.dev.delta.repositories.MedecineCategoryRepository;

@Service
public class MedecineCategoryService {

	@Autowired
	MedecineCategoryRepository medecineCategoryRepository;
	
	
	public MedecineCategory addMedecineCategory(MedecineCategory medecineCategory)
	{
		return medecineCategoryRepository.save(medecineCategory);
	}
	
	public List<MedecineCategory> findAll()
	{
		return medecineCategoryRepository.findAll();
	}
	
	
	public MedecineCategory updateMedecineCategory(MedecineCategory medecineCategory)
	{
		return medecineCategoryRepository.save(medecineCategory);
	}
	
	public MedecineCategory findMedecineCategoryById(Long id) 
	{
		
		return medecineCategoryRepository
				.findById(id)
				.orElseThrow(()->new MedecineCategoryNotFoundException("MedecineCategoryController is not found"));
	}
	
	public void deleteMedecineCategory(Long id)
	{
		medecineCategoryRepository.deleteById(id);
	}
	
	
}
