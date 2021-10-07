package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.MedecineType;
import com.dev.delta.exceptions.MedecineTypeNotFoundException;
import com.dev.delta.repositories.MedecineTypeRepository;

@Service
public class MedecineTypeService {

	@Autowired
	MedecineTypeRepository medecineTypeRepository;
	
	
	public MedecineType addMedecineType(MedecineType medecineType)
	{
		return medecineTypeRepository.save(medecineType);
	}
	
	public List<MedecineType> findAll()
	{
		return medecineTypeRepository.findAll();
	}
	
	
	public MedecineType updateMedecineType(MedecineType medecineType)
	{
		return medecineTypeRepository.save(medecineType);
	}
	
	public MedecineType findMedecineTypeById(Long id) 
	{
		
		return medecineTypeRepository
				.findById(id)
				.orElseThrow(()->new MedecineTypeNotFoundException("MedecineType is not found"));
	}
	
	public void deleteMedecineType(Long id)
	{
		medecineTypeRepository.deleteById(id);
	}
	
}
