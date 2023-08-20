package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.IncomeRepository;

@Service
public class IncomeDTO implements DTO{

	@Autowired
	IncomeRepository  incomeRepository;
	
	@Override
	public void populate() {
		incomeRepository.save(income);
	}

}
