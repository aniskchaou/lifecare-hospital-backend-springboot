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

import com.dev.delta.entities.BedType;
import com.dev.delta.services.BedTypeService;
@RestController
@RequestMapping("bedtype")
@CrossOrigin
public class BedTypeController {

	@Autowired
	BedTypeService bedTypeHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody BedType projectBedType, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        BedType newPT = bedTypeHospitalService.addBedType(projectBedType);

	        return new ResponseEntity<BedType>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<BedType> getAllBedTypes()
   {
	   return bedTypeHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<BedType> getBedTypeById(@PathVariable Long id)
   {
	   BedType bedTypeHospital=bedTypeHospitalService.findBedTypeById(id);
	   return new ResponseEntity<BedType>(bedTypeHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBedType(@PathVariable Long id)
   {
	   bedTypeHospitalService.deleteBedType(id);
	   return new ResponseEntity<String>("bedTypeHospital was deleted",HttpStatus.OK);
   }
	
	
}
