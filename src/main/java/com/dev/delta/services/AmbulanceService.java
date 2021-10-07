package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Ambulance;
import com.dev.delta.exceptions.AmbulanceNotFoundException;
import com.dev.delta.repositories.AmbulanceRepository;

@Service
public class AmbulanceService {
	@Autowired
	AmbulanceRepository ambulanceRepository;
	
	
	public Ambulance addAmbulance(Ambulance ambulance)
	{
		return ambulanceRepository.save(ambulance);
	}
	
	public List<Ambulance> findAll()
	{
		return ambulanceRepository.findAll();
	}
	
	
	public Ambulance updateAmbulance(Ambulance ambulance)
	{
		return ambulanceRepository.save(ambulance);
	}
	
	public Ambulance findById(Long id) 
	{
		
		return ambulanceRepository
				.findById(id)
				.orElseThrow(()->new AmbulanceNotFoundException("Ambulance is not found"));
	}
	
	public void deleteAmbulance(Long id)
	{
		ambulanceRepository.deleteById(id);
	}


}
