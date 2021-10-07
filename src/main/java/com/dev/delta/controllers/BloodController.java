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

import com.dev.delta.entities.Blood;
import com.dev.delta.services.BloodService;
@RestController
@RequestMapping("/blood")
@CrossOrigin
public class BloodController {
	@Autowired
	BloodService bloodHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Blood projectBlood, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Blood newPT = bloodHospitalService.addBlood(projectBlood);

	        return new ResponseEntity<Blood>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Blood> getAllBloods()
   {
	   return bloodHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Blood> getBloodById(@PathVariable Long id)
   {
	   Blood bloodHospital=bloodHospitalService.findBloodById(id);
	   return new ResponseEntity<Blood>(bloodHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBlood(@PathVariable Long id)
   {
	   bloodHospitalService.deleteBlood(id);
	   return new ResponseEntity<String>("bloodHospital was deleted",HttpStatus.OK);
   }
	
	
	
}
