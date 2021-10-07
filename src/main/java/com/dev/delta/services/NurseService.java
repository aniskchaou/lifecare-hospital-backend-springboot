package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Nurse;
import com.dev.delta.exceptions.NurseNotFoundException;
import com.dev.delta.repositories.NurseRepository;

@Service
public class NurseService {

	@Autowired
	NurseRepository nurseRepository;
	
	
	public Nurse addNurse(Nurse nurse)
	{
		return nurseRepository.save(nurse);
	}
	
	public List<Nurse> findAll()
	{
		return nurseRepository.findAll();
	}
	
	
	public Nurse updateNurse(Nurse nurse)
	{
		return nurseRepository.save(nurse);
	}
	
	public Nurse findNurseById(Long id) 
	{
		
		return nurseRepository
				.findById(id)
				.orElseThrow(()->new NurseNotFoundException("Nurse is not found"));
	}
	
	public void deleteNurse(Long id)
	{
		nurseRepository.deleteById(id);
	}
	
}
