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

import com.dev.delta.entities.Appointement;
import com.dev.delta.services.AppointementService;


@RestController
@RequestMapping("/appointement")
@CrossOrigin
public class AppointementController {
	@Autowired
	AppointementService appointementHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Appointement projectAppointement, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Appointement newPT = appointementHospitalService.saveOrUpdate(projectAppointement);

	        return new ResponseEntity<Appointement>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Appointement> getAllAppointements()
   {
	   return appointementHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Appointement> getAppointementById(@PathVariable Long id)
   {
	   Appointement appointementHospital=appointementHospitalService.findById(id);
	   return new ResponseEntity<Appointement>(appointementHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteAppointement(@PathVariable Long id)
   {
	   appointementHospitalService.delete(id);
	   return new ResponseEntity<String>("appointementHospital was deleted",HttpStatus.OK);
   }
}
