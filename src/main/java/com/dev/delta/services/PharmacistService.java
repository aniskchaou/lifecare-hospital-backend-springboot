package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Pharmacist;
import com.dev.delta.exceptions.PharmacistNotFound;
import com.dev.delta.repositories.PharmacistRepository;

@Service
public class PharmacistService {
	@Autowired
	PharmacistRepository  pharmacistRepository;
	
	public Pharmacist saveOrUpdate(Pharmacist pharmacist)
	{
		
		return pharmacistRepository.save(pharmacist);
	}
	
	public Iterable<Pharmacist> findAll()
	{
		return pharmacistRepository.findAll();
	}
	
	public Pharmacist findById(Long id)
	{
		return pharmacistRepository.findById(id).orElseThrow(()->new PharmacistNotFound("Pharmacist Not found."));
	}
	
	public void delete(Long id)
	{
		Pharmacist pharmacist=findById(id);
		pharmacistRepository.delete(pharmacist);
	}
	
}
