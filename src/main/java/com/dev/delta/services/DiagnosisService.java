package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Diagnosis;
import com.dev.delta.exceptions.DiagnosisNotFoundException;
import com.dev.delta.repositories.DiagnosisRepository;

@Service
public class DiagnosisService {
	@Autowired
	DiagnosisRepository diagnosisRepository;
	
	
	public Diagnosis addDiagnosis(Diagnosis diagnosis)
	{
		return diagnosisRepository.save(diagnosis);
	}
	
	public List<Diagnosis> findAll()
	{
		return diagnosisRepository.findAll();
	}
	
	
	public Diagnosis updateDiagnosis(Diagnosis diagnosis)
	{
		return diagnosisRepository.save(diagnosis);
	}
	
	public Diagnosis findDiagnosisById(Long id) 
	{
		
		return diagnosisRepository
				.findById(id)
				.orElseThrow(()->new DiagnosisNotFoundException("Diagnosis is not found"));
	}
	
	public void deleteDiagnosis(Long id)
	{
		diagnosisRepository.deleteById(id);
	}
	
}
