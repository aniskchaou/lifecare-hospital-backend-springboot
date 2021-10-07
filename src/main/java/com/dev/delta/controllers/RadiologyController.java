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

import com.dev.delta.entities.Radiology;
import com.dev.delta.services.RadiologyService;


@RestController
@RequestMapping("/radiology")
@CrossOrigin
public class RadiologyController {
	@Autowired
	RadiologyService radiologyHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Radiology projectRadiology, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Radiology newPT = radiologyHospitalService.addRadiology(projectRadiology);

	        return new ResponseEntity<Radiology>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Radiology> getAllRadiologys()
   {
	   return radiologyHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Radiology> getRadiologyById(@PathVariable Long id)
   {
	   Radiology radiologyHospital=radiologyHospitalService.findRadiologyById(id);
	   return new ResponseEntity<Radiology>(radiologyHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteRadiology(@PathVariable Long id)
   {
	   radiologyHospitalService.deleteRadiology(id);
	   return new ResponseEntity<String>("radiologyHospital was deleted",HttpStatus.OK);
   }
	
	
	
}
