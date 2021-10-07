package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.VaccinatedPeople;
import com.dev.delta.exceptions.VaccinatedPeopleNotFoundException;
import com.dev.delta.repositories.VaccinatedPeopleRepository;

@Service
public class VaccinatedPeopleService {
	@Autowired
	VaccinatedPeopleRepository vaccinatedPeopleRepository;
	
	
	public VaccinatedPeople addVaccinatedPeople(VaccinatedPeople vaccinatedPeople)
	{
		return vaccinatedPeopleRepository.save(vaccinatedPeople);
	}
	
	public List<VaccinatedPeople> findAll()
	{
		return vaccinatedPeopleRepository.findAll();
	}
	
	
	public VaccinatedPeople updateVaccinatedPeople(VaccinatedPeople vaccinatedPeople)
	{
		return vaccinatedPeopleRepository.save(vaccinatedPeople);
	}
	
	public VaccinatedPeople findVaccinatedPeopleById(Long id) 
	{
		
		return vaccinatedPeopleRepository
				.findById(id)
				.orElseThrow(()->new VaccinatedPeopleNotFoundException("VaccinatedPeople is not found"));
	}
	
	public void deleteVaccinatedPeople(Long id)
	{
		vaccinatedPeopleRepository.deleteById(id);
	}
}
