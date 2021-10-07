package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Employee;
import com.dev.delta.exceptions.EmployeeNotFound;
import com.dev.delta.repositories.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository  employeeRepository;
	
	public Employee saveOrUpdate(Employee employee)
	{
		
		return employeeRepository.save(employee);
	}
	
	public Iterable<Employee> findAll()
	{
		return employeeRepository.findAll();
	}
	
	public Employee findById(Long id)
	{
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFound("Employee Not found."));
	}
	
	public void delete(Long id)
	{
		Employee employee=findById(id);
		employeeRepository.delete(employee);
	}
}
