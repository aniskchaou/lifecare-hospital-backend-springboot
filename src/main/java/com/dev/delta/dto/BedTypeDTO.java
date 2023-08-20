package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.BedTypeRepository;

@Service
public class BedTypeDTO implements DTO{

	@Autowired
	BedTypeRepository bedTypeRepository;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
		bedType.setBedType("");
		bedType.setDescription("");
		bedTypeRepository.save(bedType);
	}

}
