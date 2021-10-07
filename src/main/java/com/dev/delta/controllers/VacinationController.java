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

import com.dev.delta.entities.Vaccination;
import com.dev.delta.services.VacinationService;


@RestController
@RequestMapping("/vaccination")
@CrossOrigin
public class VacinationController {
	@Autowired
	VacinationService vaccinationHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Vaccination projectVaccination, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Vaccination newPT = vaccinationHospitalService.addVaccination(projectVaccination);

	        return new ResponseEntity<Vaccination>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Vaccination> getAllVaccinations()
   {
	   return vaccinationHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Vaccination> getVaccinationById(@PathVariable Long id)
   {
	   Vaccination vaccinationHospital=vaccinationHospitalService.findVaccinationById(id);
	   return new ResponseEntity<Vaccination>(vaccinationHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteVaccination(@PathVariable Long id)
   {
	   vaccinationHospitalService.deleteVaccination(id);
	   return new ResponseEntity<String>("vaccinationHospital was deleted",HttpStatus.OK);
   }
	
}
