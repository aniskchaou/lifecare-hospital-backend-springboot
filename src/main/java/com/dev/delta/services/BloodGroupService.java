package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.BloodGroup;
import com.dev.delta.exceptions.BloodGroupNotFoundException;
import com.dev.delta.repositories.BloodGroupRepository;

@Service
public class BloodGroupService {
	@Autowired
	BloodGroupRepository bloodGroupRepository;
	
	
	public BloodGroup addBloodGroup(BloodGroup bloodGroup)
	{
		return bloodGroupRepository.save(bloodGroup);
	}
	
	public List<BloodGroup> findAll()
	{
		return bloodGroupRepository.findAll();
	}
	
	
	public BloodGroup updateBloodGroup(BloodGroup bloodGroup)
	{
		return bloodGroupRepository.save(bloodGroup);
	}
	
	public BloodGroup findBloodGroupById(Long id) 
	{
		
		return bloodGroupRepository
				.findById(id)
				.orElseThrow(()->new BloodGroupNotFoundException("BloodGroup is not found"));
	}
	
	public void deleteBloodGroup(Long id)
	{
		bloodGroupRepository.deleteById(id);
	}
}
