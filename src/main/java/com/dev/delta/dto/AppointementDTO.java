package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.AppointementRepository;

@Service
public class AppointementDTO implements DTO{

	@Autowired
	AppointementRepository appointementRepository;
	
	
	@Override
	public void populate() {
		/*
		 * appointement.setDate("d"); appointement.setDepartement_id("");
		 * appointement.setPatient_id(""); appointement.setProblem("");
		 * appointement.setStatus(""); appointementRepository.save(appointement);
		 */
		
	}

}
