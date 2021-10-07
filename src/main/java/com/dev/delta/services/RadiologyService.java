package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Radiology;
import com.dev.delta.exceptions.RadiologyNotFoundException;
import com.dev.delta.repositories.RadiologyRepository;

@Service
public class RadiologyService {
	@Autowired
	RadiologyRepository radiologyRepository;
	
	
	public Radiology addRadiology(Radiology radiology)
	{
		return radiologyRepository.save(radiology);
	}
	
	public List<Radiology> findAll()
	{
		return radiologyRepository.findAll();
	}
	
	
	public Radiology updateRadiology(Radiology radiology)
	{
		return radiologyRepository.save(radiology);
	}
	
	public Radiology findRadiologyById(Long id) 
	{
		
		return radiologyRepository
				.findById(id)
				.orElseThrow(()->new RadiologyNotFoundException("Radiology is not found"));
	}
	
	public void deleteRadiology(Long id)
	{
		radiologyRepository.deleteById(id);
	}
}
