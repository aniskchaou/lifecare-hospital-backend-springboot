package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.RadiologyCategory;
import com.dev.delta.exceptions.RadiologyCategoryNotFoundException;
import com.dev.delta.repositories.RadiologyCategoryRepository;


@Service
public class RadiologyCategoryService {
	@Autowired
	RadiologyCategoryRepository radiologyCategoryRepository;
	
	
	public RadiologyCategory addRadiologyCategory(RadiologyCategory radiologyCategory)
	{
		return radiologyCategoryRepository.save(radiologyCategory);
	}
	
	public List<RadiologyCategory> findAll()
	{
		return radiologyCategoryRepository.findAll();
	}
	
	
	public RadiologyCategory updateRadiologyCategory(RadiologyCategory radiologyCategory)
	{
		return radiologyCategoryRepository.save(radiologyCategory);
	}
	
	public RadiologyCategory findRadiologyCategoryById(Long id) 
	{
		
		return radiologyCategoryRepository
				.findById(id)
				.orElseThrow(()->new RadiologyCategoryNotFoundException("RadiologyCategoryController is not found"));
	}
	
	public void deleteRadiologyCategory(Long id)
	{
		radiologyCategoryRepository.deleteById(id);
	}
}
