package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.DepartementRepository;

@Service
public class DepartementDTO implements DTO{

	@Autowired
	DepartementRepository  departementRepository;
	
	@Override
	public void populate() {
		departement.setName("zer");
		departement.setStatus("zer");
		departement.setDescription("zer");
		departementRepository.save(departement);
		
	}

}
