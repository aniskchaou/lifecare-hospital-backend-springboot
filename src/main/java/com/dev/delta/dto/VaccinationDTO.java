package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.VaccinationRepository;

@Service
public class VaccinationDTO implements DTO{

	@Autowired
	VaccinationRepository  vaccinationRepository;

	@Override
	public void populate() {
		vaccination.setCommercialName("");
		vaccination.setConstractor("");
		vaccination.setName("");
		vaccinationRepository.save(vaccination);
		
	}
	
}
