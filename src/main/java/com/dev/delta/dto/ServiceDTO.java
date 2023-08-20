package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.ServiceRepository;

@Service
public class ServiceDTO implements DTO{

	@Autowired
	ServiceRepository repositoryServiceRepository;

	@Override
	public void populate() {
		service.setAmount("");
		service.setDescription("");
		service.setName("");
		service.setQuantity("");
		service.setStatus("");
		repositoryServiceRepository.save(service);
		
	}
}
