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

import com.dev.delta.entities.Ambulance;
import com.dev.delta.services.AmbulanceService;
@RestController
@RequestMapping("/ambulance")
@CrossOrigin
public class AmbulanceController {
	@Autowired
	AmbulanceService ambulanceHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Ambulance projectAmbulance, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Ambulance newPT = ambulanceHospitalService.addAmbulance(projectAmbulance);

	        return new ResponseEntity<Ambulance>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Ambulance> getAllAmbulances()
   {
	   return ambulanceHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Ambulance> getAmbulanceById(@PathVariable Long id)
   {
	   Ambulance ambulanceHospital=ambulanceHospitalService.findById(id);
	   return new ResponseEntity<Ambulance>(ambulanceHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteAmbulance(@PathVariable Long id)
   {
	   ambulanceHospitalService.deleteAmbulance(id);
	   return new ResponseEntity<String>("ambulanceHospital was deleted",HttpStatus.OK);
   }
	
	
}
