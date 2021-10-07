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

import com.dev.delta.entities.RadiologyCategory;
import com.dev.delta.services.RadiologyCategoryService;

@RestController
@RequestMapping("/radiologycategory")
@CrossOrigin
public class RadiologyCategoryController {
	@Autowired
	RadiologyCategoryService radiologyCategoryHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody RadiologyCategory projectRadiologyCategory, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        RadiologyCategory newPT = radiologyCategoryHospitalService.addRadiologyCategory(projectRadiologyCategory);

	        return new ResponseEntity<RadiologyCategory>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<RadiologyCategory> getAllRadiologyCategorys()
   {
	   return radiologyCategoryHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<RadiologyCategory> getRadiologyCategoryById(@PathVariable Long id)
   {
	   RadiologyCategory radiologyCategoryHospital=radiologyCategoryHospitalService.findRadiologyCategoryById(id);
	   return new ResponseEntity<RadiologyCategory>(radiologyCategoryHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteRadiologyCategory(@PathVariable Long id)
   {
	   radiologyCategoryHospitalService.deleteRadiologyCategory(id);
	   return new ResponseEntity<String>("radiologyCategoryHospital was deleted",HttpStatus.OK);
   }
	
	
}
