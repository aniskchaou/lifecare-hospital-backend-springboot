package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Prescription;
import com.dev.delta.exceptions.PrescriptionNotFound;
import com.dev.delta.repositories.PrescriptionRepository;


@Service
public class PrescriptionService {
	@Autowired
	PrescriptionRepository  prescriptionRepository;
	
	public Prescription saveOrUpdate(Prescription prescription)
	{
		
		return prescriptionRepository.save(prescription);
	}
	
	public Iterable<Prescription> findAll()
	{
		return prescriptionRepository.findAll();
	}
	
	public Prescription findById(Long id)
	{
		return prescriptionRepository.findById(id).orElseThrow(()-> new PrescriptionNotFound("Prescription not found."));
	}
	
	public void delete(Long id)
	{
		Prescription prescription=findById(id);
		prescriptionRepository.delete(prescription);
	}
}
