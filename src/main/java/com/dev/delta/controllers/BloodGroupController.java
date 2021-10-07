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

import com.dev.delta.entities.BloodGroup;
import com.dev.delta.services.BloodGroupService;
@RestController
@RequestMapping("/bloodgroup")
@CrossOrigin
public class BloodGroupController {
	@Autowired
	BloodGroupService bloodGroupHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody BloodGroup projectBloodGroup, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        BloodGroup newPT = bloodGroupHospitalService.addBloodGroup(projectBloodGroup);

	        return new ResponseEntity<BloodGroup>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<BloodGroup> getAllBloodGroups()
   {
	   return bloodGroupHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<BloodGroup> getBloodGroupById(@PathVariable Long id)
   {
	   BloodGroup bloodGroupHospital=bloodGroupHospitalService.findBloodGroupById(id);
	   return new ResponseEntity<BloodGroup>(bloodGroupHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBloodGroup(@PathVariable Long id)
   {
	   bloodGroupHospitalService.deleteBloodGroup(id);
	   return new ResponseEntity<String>("bloodGroupHospital was deleted",HttpStatus.OK);
   }
	
}
