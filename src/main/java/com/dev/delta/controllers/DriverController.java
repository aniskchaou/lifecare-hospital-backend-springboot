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

import com.dev.delta.entities.Driver;
import com.dev.delta.services.DriverService;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
	@Autowired
	DriverService driverHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Driver projectDriver, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Driver newPT = driverHospitalService.addDriver(projectDriver);

	        return new ResponseEntity<Driver>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Driver> getAllDrivers()
   {
	   return driverHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Driver> getDriverById(@PathVariable Long id)
   {
	   Driver driverHospital=driverHospitalService.findDriverById(id);
	   return new ResponseEntity<Driver>(driverHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteDriver(@PathVariable Long id)
   {
	   driverHospitalService.deleteDriver(id);
	   return new ResponseEntity<String>("driverHospital was deleted",HttpStatus.OK);
   }
	
	
}
