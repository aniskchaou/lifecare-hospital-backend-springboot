package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.BloodDonation;
import com.dev.delta.exceptions.BloodDonationNotFoundException;
import com.dev.delta.repositories.BloodDonationRepository;

@Service
public class BloodDonationService {
	@Autowired
	BloodDonationRepository bloodDonationRepository;
	
	
	public BloodDonation addBloodDonation(BloodDonation bloodDonation)
	{
		return bloodDonationRepository.save(bloodDonation);
	}
	
	public List<BloodDonation> findAll()
	{
		return bloodDonationRepository.findAll();
	}
	
	
	public BloodDonation updateBloodDonation(BloodDonation bloodDonation)
	{
		return bloodDonationRepository.save(bloodDonation);
	}
	
	public BloodDonation findBloodDonationById(Long id) 
	{
		
		return bloodDonationRepository
				.findById(id)
				.orElseThrow(()->new BloodDonationNotFoundException("BloodDonation is not found"));
	}
	
	public void deleteBloodDonation(Long id)
	{
		bloodDonationRepository.deleteById(id);
	}
}
