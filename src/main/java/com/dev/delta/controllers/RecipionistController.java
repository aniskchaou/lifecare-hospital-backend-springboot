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

import com.dev.delta.entities.Recipionist;
import com.dev.delta.services.RecipionistService;


@RestController
@RequestMapping("/recipionist")
@CrossOrigin
public class RecipionistController {
	@Autowired
	RecipionistService recipionistHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Recipionist projectRecipionist, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Recipionist newPT = recipionistHospitalService.addReceptionist(projectRecipionist);

	        return new ResponseEntity<Recipionist>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Recipionist> getAllRecipionists()
   {
	   return recipionistHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Recipionist> getRecipionistById(@PathVariable Long id)
   {
	   Recipionist recipionistHospital=recipionistHospitalService.findReceptionistById(id);
	   return new ResponseEntity<Recipionist>(recipionistHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteRecipionist(@PathVariable Long id)
   {
	   recipionistHospitalService.deleteReceptionist(id);
	   return new ResponseEntity<String>("recipionistHospital was deleted",HttpStatus.OK);
   }

}
