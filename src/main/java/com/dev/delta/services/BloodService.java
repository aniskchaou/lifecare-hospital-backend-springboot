package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Blood;
import com.dev.delta.exceptions.BloodNotFoundException;
import com.dev.delta.repositories.BloodRepository;

@Service
public class BloodService {
	@Autowired
	BloodRepository bloodRepository;
	
	
	public Blood addBlood(Blood blood)
	{
		return bloodRepository.save(blood);
	}
	
	public List<Blood> findAll()
	{
		return bloodRepository.findAll();
	}
	
	
	public Blood updateBlood(Blood blood)
	{
		return bloodRepository.save(blood);
	}
	
	public Blood findBloodById(Long id) 
	{
		
		return bloodRepository
				.findById(id)
				.orElseThrow(()->new BloodNotFoundException("Blood is not found"));
	}
	
	public void deleteBlood(Long id)
	{
		bloodRepository.deleteById(id);
	}
	
}
