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

import com.dev.delta.entities.Laboratorist;
import com.dev.delta.services.LaboratoristService;


@RestController
@RequestMapping("/laboratorist")
@CrossOrigin
public class LaboratoristController {
	@Autowired
	LaboratoristService laboratoristHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Laboratorist projectLaboratorist, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Laboratorist newPT = laboratoristHospitalService.addLaboratorist(projectLaboratorist);

	        return new ResponseEntity<Laboratorist>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Laboratorist> getAllLaboratorists()
   {
	   return laboratoristHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Laboratorist> getLaboratoristById(@PathVariable Long id)
   {
	   Laboratorist laboratoristHospital=laboratoristHospitalService.findLaboratoristById(id);
	   return new ResponseEntity<Laboratorist>(laboratoristHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteLaboratorist(@PathVariable Long id)
   {
	   laboratoristHospitalService.deleteLaboratorist(id);
	   return new ResponseEntity<String>("laboratoristHospital was deleted",HttpStatus.OK);
   }
	
	
}
