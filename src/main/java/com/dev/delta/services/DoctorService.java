package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Doctor;
import com.dev.delta.exceptions.DoctorNotFound;
import com.dev.delta.repositories.DoctorRepository;


@Service
public class DoctorService {
	@Autowired
	DoctorRepository  doctorRepository;
	
	public Doctor saveOrUpdate(Doctor doctor)
	{
		
		return doctorRepository.save(doctor);
	}
	
	public Iterable<Doctor> findAll()
	{
		return doctorRepository.findAll();
	}
	
	public Doctor findById(Long id)
	{
		return doctorRepository.findById(id).orElseThrow(()->new DoctorNotFound("Doctor Not Found."));
	}
	
	public void delete(Long id)
	{
		Doctor doctor=findById(id);
		doctorRepository.delete(doctor);
	}
}
