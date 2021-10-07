package com.dev.delta.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.delta.entities.Employee;
import com.dev.delta.services.EmployeeService;



@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
	@Autowired
	EmployeeService employeeHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Employee projectEmployee, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Employee newPT = employeeHospitalService.saveOrUpdate(projectEmployee);

	        return new ResponseEntity<Employee>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Employee> getAllEmployees()
   {
	   return employeeHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
   {
	   Employee employeeHospital=employeeHospitalService.findById(id);
	   return new ResponseEntity<Employee>(employeeHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
   {
	   employeeHospitalService.delete(id);
	   return new ResponseEntity<String>("employeeHospital was deleted",HttpStatus.OK);
   }
     
     
}
