package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.VaccinatedPeopleRepository;

@Service
public class VaccinatedPeopleDTO  implements DTO{

	@Autowired
	VaccinatedPeopleRepository vaccinatedPeopleRepository;
	
	@Override
	public void populate() {
		vaccinatedPeopleRepository.save(vaccinatedPeople);
		
	}

}
