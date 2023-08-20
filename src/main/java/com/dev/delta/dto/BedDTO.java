package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BedRepository;

@Service
public class BedDTO implements DTO{

	@Autowired
	BedRepository bedRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		bed.setBedNumber("mk,lk,ml");
		bed.setBedType(bedType);
		bed.setFloor("lknmlm");

		bedRepository.save(bed);
	}

}
