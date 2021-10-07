package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Appointement;
import com.dev.delta.exceptions.AppointementNotFoundException;
import com.dev.delta.repositories.AppointementRepository;


@Service
public class AppointementService {
	@Autowired
	AppointementRepository  appointementRepository;
	
	public Appointement saveOrUpdate(Appointement appointement)
	{
		
		return appointementRepository.save(appointement);
	}
	
	public Iterable<Appointement> findAll()
	{
		return appointementRepository.findAll();
	}
	
	public Appointement findById(Long id)
	{
		return appointementRepository.findById(id).orElseThrow(()->new AppointementNotFoundException("Appoitement Not Found"));
	}
	
	public void delete(Long id)
	{
		Appointement appointement=findById(id);
		appointementRepository.delete(appointement);
	}
}
