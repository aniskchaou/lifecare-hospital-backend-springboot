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

import com.dev.delta.entities.RadiologyType;
import com.dev.delta.services.RadiologyTypeService;


@RestController
@RequestMapping("/radiologytype")
@CrossOrigin
public class RadiologyTypeController {
	@Autowired
	RadiologyTypeService radiologyTypeHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody RadiologyType projectRadiologyType, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        RadiologyType newPT = radiologyTypeHospitalService.addRadiologyType(projectRadiologyType);

	        return new ResponseEntity<RadiologyType>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<RadiologyType> getAllRadiologyTypes()
   {
	   return radiologyTypeHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<RadiologyType> getRadiologyTypeById(@PathVariable Long id)
   {
	   RadiologyType radiologyTypeHospital=radiologyTypeHospitalService.findRadiologyTypeById(id);
	   return new ResponseEntity<RadiologyType>(radiologyTypeHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteRadiologyType(@PathVariable Long id)
   {
	   radiologyTypeHospitalService.deleteRadiologyType(id);
	   return new ResponseEntity<String>("radiologyTypeHospital was deleted",HttpStatus.OK);
   }
	
	
}
