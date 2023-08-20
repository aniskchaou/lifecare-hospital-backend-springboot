package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Vaccination;
import com.dev.delta.exceptions.VaccinationNotFoundException;
import com.dev.delta.repositories.VaccinationRepository;

@Service
public class VacinationService {
	@Autowired
	VaccinationRepository vaccinationRepository;
	
	
	public Vaccination addVaccination(Vaccination vaccination)
	{
		return vaccinationRepository.save(vaccination);
	}
	
	public List<Vaccination> findAll()
	{
		return vaccinationRepository.findAll();
	}
	
	
	public Vaccination updateVaccination(Vaccination vaccination)
	{
		return vaccinationRepository.save(vaccination);
	}
	
	public Vaccination findVaccinationById(Long id) 
	{
		
		return vaccinationRepository
				.findById(id)
				.orElseThrow(()->new VaccinationNotFoundException("Vaccination is not found"));
	}
	
	public void deleteVaccination(Long id)
	{
		vaccinationRepository.deleteById(id);
	}
}
