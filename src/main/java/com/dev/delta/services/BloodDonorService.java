package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.BloodDonor;
import com.dev.delta.exceptions.BloodDonorNotFoundException;
import com.dev.delta.repositories.BloodDonorRepository;

@Service
public class BloodDonorService {
	@Autowired
	BloodDonorRepository bloodDonorRepository;
	
	
	public BloodDonor addBloodDonor(BloodDonor bloodDonor)
	{
		return bloodDonorRepository.save(bloodDonor);
	}
	
	public List<BloodDonor> findAll()
	{
		return bloodDonorRepository.findAll();
	}
	
	
	public BloodDonor updateBloodDonor(BloodDonor bloodDonor)
	{
		return bloodDonorRepository.save(bloodDonor);
	}
	
	public BloodDonor findBloodDonorById(Long id) 
	{
		
		return bloodDonorRepository
				.findById(id)
				.orElseThrow(()->new BloodDonorNotFoundException("BloodDonor is not found"));
	}
	
	public void deleteBloodDonor(Long id)
	{
		bloodDonorRepository.deleteById(id);
	}
	
}
