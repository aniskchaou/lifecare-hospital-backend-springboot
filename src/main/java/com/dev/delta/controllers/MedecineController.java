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

import com.dev.delta.entities.Medecine;
import com.dev.delta.services.MedecineService;


@RestController
@RequestMapping("/medecine")
@CrossOrigin
public class MedecineController {

	@Autowired
	MedecineService medecineHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Medecine projectMedecine, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Medecine newPT = medecineHospitalService.addMedecine(projectMedecine);

	        return new ResponseEntity<Medecine>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Medecine> getAllMedecines()
   {
	   return medecineHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Medecine> getMedecineById(@PathVariable Long id)
   {
	   Medecine medecineHospital=medecineHospitalService.findMedecineById(id);
	   return new ResponseEntity<Medecine>(medecineHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteMedecine(@PathVariable Long id)
   {
	   medecineHospitalService.deleteMedecine(id);
	   return new ResponseEntity<String>("medecineHospital was deleted",HttpStatus.OK);
   }
	
	
}
