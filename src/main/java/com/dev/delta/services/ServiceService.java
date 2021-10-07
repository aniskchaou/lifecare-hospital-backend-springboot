package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.entities.Service;
import com.dev.delta.exceptions.ServiceNotFound;
import com.dev.delta.repositories.ServiceRepository;


@org.springframework.stereotype.Service
public class ServiceService {
	@Autowired
	ServiceRepository  serviceRepository;
	
	public Service saveOrUpdate(Service service)
	{
		
		return serviceRepository.save(service);
	}
	
	public Iterable<Service> findAll()
	{
		return serviceRepository.findAll();
	}
	
	public Service findById(Long id)
	{
		return serviceRepository.findById(id).orElseThrow(()->new ServiceNotFound("Service Not found."));
	}
	
	public void delete(Long id)
	{
		Service service=findById(id);
		serviceRepository.delete(service);
	}
}
