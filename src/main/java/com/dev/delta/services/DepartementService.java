package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Departement;
import com.dev.delta.exceptions.DepartementNotFound;
import com.dev.delta.repositories.DepartementRepository;


@Service
public class DepartementService {
	@Autowired
	DepartementRepository  departementRepository;
	
	public Departement saveOrUpdate(Departement departement)
	{
		
		return departementRepository.save(departement);
	}
	
	public Iterable<Departement> findAll()
	{
		return departementRepository.findAll();
	}
	
	public Departement findById(Long id)
	{
		return departementRepository.findById(id).orElseThrow(()->new DepartementNotFound("Departement Not Found."));
	}
	
	public void delete(Long id)
	{
		Departement departement=findById(id);
		departementRepository.delete(departement);
	}
}
