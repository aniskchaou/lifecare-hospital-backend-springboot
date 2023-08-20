package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BloodGroupRepository;

@Service
public class BloodGroupDTO implements DTO{

	@Autowired
	BloodGroupRepository  bloodGroupRepository;	
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		bloodGroup.setName("gfx");
		bloodGroupRepository.save(bloodGroup);
	}

	
}
