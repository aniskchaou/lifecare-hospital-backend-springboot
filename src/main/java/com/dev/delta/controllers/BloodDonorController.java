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

import com.dev.delta.entities.BloodDonor;
import com.dev.delta.services.BloodDonorService;
@RestController
@RequestMapping("/blooddonor")
@CrossOrigin
public class BloodDonorController {
	@Autowired
	BloodDonorService bloodDonorHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody BloodDonor projectBloodDonor, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        BloodDonor newPT = bloodDonorHospitalService.addBloodDonor(projectBloodDonor);

	        return new ResponseEntity<BloodDonor>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<BloodDonor> getAllBloodDonors()
   {
	   return bloodDonorHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<BloodDonor> getBloodDonorById(@PathVariable Long id)
   {
	   BloodDonor bloodDonorHospital=bloodDonorHospitalService.findBloodDonorById(id);
	   return new ResponseEntity<BloodDonor>(bloodDonorHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBloodDonor(@PathVariable Long id)
   {
	   bloodDonorHospitalService.deleteBloodDonor(id);
	   return new ResponseEntity<String>("bloodDonorHospital was deleted",HttpStatus.OK);
   }
	
	
}
