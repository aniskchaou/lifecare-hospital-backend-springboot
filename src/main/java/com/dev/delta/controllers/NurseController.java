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

import com.dev.delta.entities.Nurse;
import com.dev.delta.services.NurseService;
@RestController
@RequestMapping("/nurse")
@CrossOrigin
public class NurseController {

	@Autowired
	NurseService nurseHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Nurse projectNurse, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Nurse newPT = nurseHospitalService.addNurse(projectNurse);

	        return new ResponseEntity<Nurse>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Nurse> getAllNurses()
   {
	   return nurseHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Nurse> getNurseById(@PathVariable Long id)
   {
	   Nurse nurseHospital=nurseHospitalService.findNurseById(id);
	   return new ResponseEntity<Nurse>(nurseHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteNurse(@PathVariable Long id)
   {
	   nurseHospitalService.deleteNurse(id);
	   return new ResponseEntity<String>("nurseHospital was deleted",HttpStatus.OK);
   }
	
	
}
