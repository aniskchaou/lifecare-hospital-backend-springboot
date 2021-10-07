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

import com.dev.delta.entities.DoctorSpeciality;
import com.dev.delta.services.DoctorSpecialityService;

@RestController
@RequestMapping("/doctorspeciality")
@CrossOrigin
public class DoctorSpecialityController {
	@Autowired
	DoctorSpecialityService doctorSpecialityHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody DoctorSpeciality projectDoctorSpeciality, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        DoctorSpeciality newPT = doctorSpecialityHospitalService.addDoctorSpeciality(projectDoctorSpeciality);

	        return new ResponseEntity<DoctorSpeciality>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<DoctorSpeciality> getAllDoctorSpecialitys()
   {
	   return doctorSpecialityHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<DoctorSpeciality> getDoctorSpecialityById(@PathVariable Long id)
   {
	   DoctorSpeciality doctorSpecialityHospital=doctorSpecialityHospitalService.findDoctorSpecialityById(id);
	   return new ResponseEntity<DoctorSpeciality>(doctorSpecialityHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteDoctorSpeciality(@PathVariable Long id)
   {
	   doctorSpecialityHospitalService.deleteDoctorSpeciality(id);
	   return new ResponseEntity<String>("doctorSpecialityHospital was deleted",HttpStatus.OK);
   }
	
	
}
