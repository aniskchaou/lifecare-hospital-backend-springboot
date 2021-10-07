package com.dev.delta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Driver;
import com.dev.delta.exceptions.DriverNotFoundException;
import com.dev.delta.repositories.DriverRepository;

@Service
public class DriverService {
	@Autowired
	DriverRepository driverRepository;
	
	
	public Driver addDriver(Driver driver)
	{
		return driverRepository.save(driver);
	}
	
	public List<Driver> findAll()
	{
		return driverRepository.findAll();
	}
	
	
	public Driver updateDriver(Driver driver)
	{
		return driverRepository.save(driver);
	}
	
	public Driver findDriverById(Long id) 
	{
		
		return driverRepository
				.findById(id)
				.orElseThrow(()->new DriverNotFoundException("Driver is not found"));
	}
	
	public void deleteDriver(Long id)
	{
		driverRepository.deleteById(id);
	}
	
}
