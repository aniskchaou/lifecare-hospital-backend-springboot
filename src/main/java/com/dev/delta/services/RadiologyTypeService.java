package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.RadiologyType;
import com.dev.delta.exceptions.RadiologyTypeNotFoundException;
import com.dev.delta.repositories.RadiologyTypeRepository;

@Service
public class RadiologyTypeService {
	@Autowired
	RadiologyTypeRepository radiologyTypeRepository;
	
	
	public RadiologyType addRadiologyType(RadiologyType radiologyType)
	{
		return radiologyTypeRepository.save(radiologyType);
	}
	
	public List<RadiologyType> findAll()
	{
		return radiologyTypeRepository.findAll();
	}
	
	
	public RadiologyType updateRadiologyType(RadiologyType radiologyType)
	{
		return radiologyTypeRepository.save(radiologyType);
	}
	
	public RadiologyType findRadiologyTypeById(Long id) 
	{
		
		return radiologyTypeRepository
				.findById(id)
				.orElseThrow(()->new RadiologyTypeNotFoundException("RadiologyType is not found"));
	}
	
	public void deleteRadiologyType(Long id)
	{
		radiologyTypeRepository.deleteById(id);
	}
	
}
