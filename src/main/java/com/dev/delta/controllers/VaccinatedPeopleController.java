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

import com.dev.delta.entities.VaccinatedPeople;
import com.dev.delta.services.VaccinatedPeopleService;


@RestController
@RequestMapping("/vaccinatedpeople")
@CrossOrigin
public class VaccinatedPeopleController {
	@Autowired
	VaccinatedPeopleService vaccinatedPeopleHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody VaccinatedPeople projectVaccinatedPeople, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        VaccinatedPeople newPT = vaccinatedPeopleHospitalService.addVaccinatedPeople(projectVaccinatedPeople);

	        return new ResponseEntity<VaccinatedPeople>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<VaccinatedPeople> getAllVaccinatedPeoples()
   {
	   return vaccinatedPeopleHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<VaccinatedPeople> getVaccinatedPeopleById(@PathVariable Long id)
   {
	   VaccinatedPeople vaccinatedPeopleHospital=vaccinatedPeopleHospitalService.findVaccinatedPeopleById(id);
	   return new ResponseEntity<VaccinatedPeople>(vaccinatedPeopleHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteVaccinatedPeople(@PathVariable Long id)
   {
	   vaccinatedPeopleHospitalService.deleteVaccinatedPeople(id);
	   return new ResponseEntity<String>("vaccinatedPeopleHospital was deleted",HttpStatus.OK);
   }
	
	
	
}
