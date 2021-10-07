package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Insurance;
import com.dev.delta.exceptions.InsuranceNotFound;
import com.dev.delta.repositories.InsuranceRepository;


@Service
public class InsuranceService {
	@Autowired
	InsuranceRepository  insuranceRepository;
	
	public Insurance saveOrUpdate(Insurance insurance)
	{
		
		return insuranceRepository.save(insurance);
	}
	
	public Iterable<Insurance> findAll()
	{
		return insuranceRepository.findAll();
	}
	
	public Insurance findById(Long id)
	{
		return insuranceRepository.findById(id).orElseThrow(()->new InsuranceNotFound("Insurance Not found."));
	}
	
	public void delete(Long id)
	{
		Insurance insurance=findById(id);
		insuranceRepository.delete(insurance);
	}
}
