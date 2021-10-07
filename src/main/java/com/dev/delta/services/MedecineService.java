package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Medecine;
import com.dev.delta.exceptions.MedecineNotFoundException;
import com.dev.delta.repositories.MedecineRepository;

@Service
public class MedecineService {

	@Autowired
	MedecineRepository medecineRepository;
	
	
	public Medecine addMedecine(Medecine medecine)
	{
		return medecineRepository.save(medecine);
	}
	
	public List<Medecine> findAll()
	{
		return medecineRepository.findAll();
	}
	
	
	public Medecine updateMedecine(Medecine medecine)
	{
		return medecineRepository.save(medecine);
	}
	
	public Medecine findMedecineById(Long id) 
	{
		
		return medecineRepository
				.findById(id)
				.orElseThrow(()->new MedecineNotFoundException("Medecine is not found"));
	}
	
	public void deleteMedecine(Long id)
	{
		medecineRepository.deleteById(id);
	}
	
	
}
