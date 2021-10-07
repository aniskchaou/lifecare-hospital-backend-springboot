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

import com.dev.delta.entities.Pharmacist;
import com.dev.delta.services.PharmacistService;


@RestController
@RequestMapping("/pharmacist")
@CrossOrigin
public class PharmacistController {
	@Autowired
	PharmacistService pharmacistHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Pharmacist projectPharmacist, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Pharmacist newPT = pharmacistHospitalService.saveOrUpdate(projectPharmacist);

	        return new ResponseEntity<Pharmacist>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Pharmacist> getAllPharmacists()
   {
	   return pharmacistHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable Long id)
   {
	   Pharmacist pharmacistHospital=pharmacistHospitalService.findById(id);
	   return new ResponseEntity<Pharmacist>(pharmacistHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deletePharmacist(@PathVariable Long id)
   {
	   pharmacistHospitalService.delete(id);
	   return new ResponseEntity<String>("pharmacistHospital was deleted",HttpStatus.OK);
   }
	
	
}
