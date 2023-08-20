package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.RadiologyRepository;

@Service
public class RadiologyDTO implements DTO{

	@Autowired
	RadiologyRepository radiologyRepository;

	@Override
	public void populate() {
		//radiology.setName(radiologyCategory);
		radiology.setRadiologyType(radiologyType);
		radiology.setReportDays("");
		radiology.setStandardCharge("");
		radiology.setTestName("");
		radiologyRepository.save(radiology);
		
	}
	
	
}
