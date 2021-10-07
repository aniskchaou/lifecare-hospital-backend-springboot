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

import com.dev.delta.entities.BloodDonation;
import com.dev.delta.services.BloodDonationService;
@RestController
@RequestMapping("/blooddonation")
@CrossOrigin
public class BloodDonationController {
	@Autowired
	BloodDonationService bloodDonationHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody BloodDonation projectBloodDonation, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        BloodDonation newPT = bloodDonationHospitalService.addBloodDonation(projectBloodDonation);

	        return new ResponseEntity<BloodDonation>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<BloodDonation> getAllBloodDonations()
   {
	   return bloodDonationHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<BloodDonation> getBloodDonationById(@PathVariable Long id)
   {
	   BloodDonation bloodDonationHospital=bloodDonationHospitalService.findBloodDonationById(id);
	   return new ResponseEntity<BloodDonation>(bloodDonationHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBloodDonation(@PathVariable Long id)
   {
	   bloodDonationHospitalService.deleteBloodDonation(id);
	   return new ResponseEntity<String>("bloodDonationHospital was deleted",HttpStatus.OK);
   }
}
