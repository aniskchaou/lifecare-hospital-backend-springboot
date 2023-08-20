package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BloodRepository;

@Service
public class BloodDTO implements DTO{

	@Autowired
	BloodRepository bloodRepository;
	
	@Override
	public void populate() {
	    blood.setBloodGroup(bloodGroup);
	    blood.setRemainedBags("hg");
		bloodRepository.save(blood);
		
	}

	
}
