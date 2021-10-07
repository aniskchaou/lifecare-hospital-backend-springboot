package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.BedType;
import com.dev.delta.exceptions.BedTypeNotFoundException;
import com.dev.delta.repositories.BedTypeRepository;

@Service
public class BedTypeService {

	@Autowired
	BedTypeRepository bedTypeRepository;
	
	
	public BedType addBedType(BedType bedType)
	{
		return bedTypeRepository.save(bedType);
	}
	
	public List<BedType> findAll()
	{
		return bedTypeRepository.findAll();
	}
	
	
	public BedType updateBedType(BedType bedType)
	{
		return bedTypeRepository.save(bedType);
	}
	
	public BedType findBedTypeById(Long id) 
	{
		
		return bedTypeRepository
				.findById(id)
				.orElseThrow(()->new BedTypeNotFoundException("BedType is not found"));
	}
	
	public void deleteBedType(Long id)
	{
		bedTypeRepository.deleteById(id);
	}
}
