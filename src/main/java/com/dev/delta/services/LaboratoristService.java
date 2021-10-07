package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Laboratorist;
import com.dev.delta.exceptions.LaboratoristNotFoundException;
import com.dev.delta.repositories.LaboratoristRepository;

@Service
public class LaboratoristService {
	@Autowired
	LaboratoristRepository jobNameRepository;
	
	
	public Laboratorist addLaboratorist(Laboratorist jobName)
	{
		return jobNameRepository.save(jobName);
	}
	
	public List<Laboratorist> findAll()
	{
		return jobNameRepository.findAll();
	}
	
	
	public Laboratorist updateLaboratorist(Laboratorist jobName)
	{
		return jobNameRepository.save(jobName);
	}
	
	public Laboratorist findLaboratoristById(Long id) 
	{
		
		return jobNameRepository
				.findById(id)
				.orElseThrow(()->new LaboratoristNotFoundException("Laboratorist is not found"));
	}
	
	public void deleteLaboratorist(Long id)
	{
		jobNameRepository.deleteById(id);
	}
	
}
