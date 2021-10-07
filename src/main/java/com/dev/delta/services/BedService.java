package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Bed;
import com.dev.delta.exceptions.BedNotFoundException;
import com.dev.delta.repositories.BedRepository;

@Service
public class BedService {
	@Autowired
	BedRepository bedRepository;
	
	
	public Bed addBed(Bed bed)
	{
		return bedRepository.save(bed);
	}
	
	public List<Bed> findAll()
	{
		return bedRepository.findAll();
	}
	
	
	public Bed updateBed(Bed bed)
	{
		return bedRepository.save(bed);
	}
	
	public Bed findBedById(Long id) 
	{
		
		return bedRepository
				.findById(id)
				.orElseThrow(()->new BedNotFoundException("Bed is not found"));
	}
	
	public void deleteBed(Long id)
	{
		bedRepository.deleteById(id);
	}
}
