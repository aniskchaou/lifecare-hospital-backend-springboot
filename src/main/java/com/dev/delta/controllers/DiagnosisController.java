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

import com.dev.delta.entities.Diagnosis;
import com.dev.delta.services.DiagnosisService;

@RestController
@RequestMapping("/diagnosis")
@CrossOrigin
public class DiagnosisController {
	@Autowired
	DiagnosisService diagnosisHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Diagnosis projectDiagnosis, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Diagnosis newPT = diagnosisHospitalService.addDiagnosis(projectDiagnosis);

	        return new ResponseEntity<Diagnosis>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Diagnosis> getAllDiagnosiss()
   {
	   return diagnosisHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable Long id)
   {
	   Diagnosis diagnosisHospital=diagnosisHospitalService.findDiagnosisById(id);
	   return new ResponseEntity<Diagnosis>(diagnosisHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteDiagnosis(@PathVariable Long id)
   {
	   diagnosisHospitalService.deleteDiagnosis(id);
	   return new ResponseEntity<String>("diagnosisHospital was deleted",HttpStatus.OK);
   }
	
	
	
}
