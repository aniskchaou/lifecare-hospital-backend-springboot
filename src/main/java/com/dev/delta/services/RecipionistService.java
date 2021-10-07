package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Recipionist;
import com.dev.delta.exceptions.ReceptionistNotFoundException;
import com.dev.delta.repositories.RecipionistRepository;

@Service
public class RecipionistService {
	@Autowired
	RecipionistRepository receptionistRepository;
	
	
	public Recipionist addReceptionist(Recipionist receptionist)
	{
		return receptionistRepository.save(receptionist);
	}
	
	public List<Recipionist> findAll()
	{
		return receptionistRepository.findAll();
	}
	
	
	public Recipionist updateReceptionist(Recipionist receptionist)
	{
		return receptionistRepository.save(receptionist);
	}
	
	public Recipionist findReceptionistById(Long id) 
	{
		
		return receptionistRepository
				.findById(id)
				.orElseThrow(()->new ReceptionistNotFoundException("Receptionist is not found"));
	}
	
	public void deleteReceptionist(Long id)
	{
		receptionistRepository.deleteById(id);
	}
}
