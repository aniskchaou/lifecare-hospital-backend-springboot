package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.DoctorSpeciality;
import com.dev.delta.exceptions.DoctorSpecialityNotFoundException;
import com.dev.delta.repositories.DoctorSpecialityRepository;

@Service
public class DoctorSpecialityService {
	@Autowired
	DoctorSpecialityRepository doctorSpecialityRepository;
	
	
	public DoctorSpeciality addDoctorSpeciality(DoctorSpeciality doctorSpeciality)
	{
		return doctorSpecialityRepository.save(doctorSpeciality);
	}
	
	public List<DoctorSpeciality> findAll()
	{
		return doctorSpecialityRepository.findAll();
	}
	
	
	public DoctorSpeciality updateDoctorSpeciality(DoctorSpeciality doctorSpeciality)
	{
		return doctorSpecialityRepository.save(doctorSpeciality);
	}
	
	public DoctorSpeciality findDoctorSpecialityById(Long id) 
	{
		
		return doctorSpecialityRepository
				.findById(id)
				.orElseThrow(()->new DoctorSpecialityNotFoundException("DoctorSpeciality is not found"));
	}
	
	public void deleteDoctorSpeciality(Long id)
	{
		doctorSpecialityRepository.deleteById(id);
	}
	
}
