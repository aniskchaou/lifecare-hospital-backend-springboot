package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.DriverRepository;

@Service
public class DriverDTO implements DTO{

	@Autowired
	DriverRepository driverRepository;

	@Override
	public void populate() {
		driver.setAddress("ggg");
		driver.setAge(",hb;j");
		driver.setEmail("jb");
		driver.setFirstName(";jnbk");
		driver.setGender(";jnbkj");
		driver.setLastName("khbk");
		driver.setLicense("jk");
		driver.setPhone("rf");
		driverRepository.save(driver);
		
	}
}
