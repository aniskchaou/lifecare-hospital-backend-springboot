package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BloodDonationRepository;

@Service
public class BloodDonationDTO implements DTO{

	@Autowired
	BloodDonationRepository bloodDonationRepository;
	
	@Override
	public void populate() {
		bloodDonation.setBags("g");
		bloodDonation.setDonorName(bloodDonor);
		bloodDonationRepository.save(bloodDonation);
		
	}

}
