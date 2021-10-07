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

import com.dev.delta.entities.Bed;
import com.dev.delta.services.BedService;
@RestController
@RequestMapping("/bed")
@CrossOrigin
public class BedController {
	@Autowired
	BedService bedHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Bed projectBed, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Bed newPT = bedHospitalService.addBed(projectBed);

	        return new ResponseEntity<Bed>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Bed> getAllBeds()
   {
	   return bedHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Bed> getBedById(@PathVariable Long id)
   {
	   Bed bedHospital=bedHospitalService.findBedById(id);
	   return new ResponseEntity<Bed>(bedHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBed(@PathVariable Long id)
   {
	   bedHospitalService.deleteBed(id);
	   return new ResponseEntity<String>("bedHospital was deleted",HttpStatus.OK);
   }
}
