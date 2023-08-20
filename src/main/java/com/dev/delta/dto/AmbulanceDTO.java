package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.AmbulanceRepository;

@Service
public class AmbulanceDTO implements DTO {

	@Autowired
	AmbulanceRepository ambulanceRepository;
	
	@Override
	public void populate() {
		ambulance.setDriver(driver);
		ambulance.setModel("hgcjh");
		ambulance.setNote("gfhg");
		ambulance.setVehicleNumber("hgdxh");
		ambulance.setYear("hgfxg");
		ambulanceRepository.save(ambulance);
		
	}

	
}
