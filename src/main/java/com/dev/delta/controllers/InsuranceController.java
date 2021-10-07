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

import com.dev.delta.entities.Insurance;
import com.dev.delta.services.InsuranceService;



@RestController
@RequestMapping("/insurance")
@CrossOrigin
public class InsuranceController {
	@Autowired
	InsuranceService insuranceHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Insurance projectInsurance, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Insurance newPT = insuranceHospitalService.saveOrUpdate(projectInsurance);

	        return new ResponseEntity<Insurance>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Insurance> getAllInsurances()
   {
	   return insuranceHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Insurance> getInsuranceById(@PathVariable Long id)
   {
	   Insurance insuranceHospital=insuranceHospitalService.findById(id);
	   return new ResponseEntity<Insurance>(insuranceHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteInsurance(@PathVariable Long id)
   {
	   insuranceHospitalService.delete(id);
	   return new ResponseEntity<String>("insuranceHospital was deleted",HttpStatus.OK);
   }
}
