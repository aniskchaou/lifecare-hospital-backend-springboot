package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BloodDonorRepository;

@Service
public class BloodDonorDTO implements DTO{

	@Autowired
	BloodDonorRepository bloodDonorRepository;
	
	@Override
	public void populate() {
		bloodDonor.setAge("");
		bloodDonor.setBloodGroup(bloodGroup);
		bloodDonor.setFirstName("");
		bloodDonor.setGender("");
		bloodDonor.setLastDonationDate("");
		bloodDonor.setLastName("");
		bloodDonorRepository.save(bloodDonor);
		
	}

}
