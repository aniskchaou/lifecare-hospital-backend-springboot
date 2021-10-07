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

import com.dev.delta.entities.MedecineType;
import com.dev.delta.services.MedecineTypeService;


@RestController
@RequestMapping("/medecinetype")
@CrossOrigin
public class MedecineTypeController {

	@Autowired
	MedecineTypeService medecineTypeHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody MedecineType projectMedecineType, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        MedecineType newPT = medecineTypeHospitalService.addMedecineType(projectMedecineType);

	        return new ResponseEntity<MedecineType>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<MedecineType> getAllMedecineTypes()
   {
	   return medecineTypeHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<MedecineType> getMedecineTypeById(@PathVariable Long id)
   {
	   MedecineType medecineTypeHospital=medecineTypeHospitalService.findMedecineTypeById(id);
	   return new ResponseEntity<MedecineType>(medecineTypeHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteMedecineType(@PathVariable Long id)
   {
	   medecineTypeHospitalService.deleteMedecineType(id);
	   return new ResponseEntity<String>("medecineTypeHospital was deleted",HttpStatus.OK);
   }
	
	
}
