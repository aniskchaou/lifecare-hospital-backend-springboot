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

import com.dev.delta.entities.MedecineCategory;
import com.dev.delta.services.MedecineCategoryService;

@RestController
@RequestMapping("/medecinecategory")
@CrossOrigin
public class MedecineCategoryController {

	@Autowired
	MedecineCategoryService medecineCategoryHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody MedecineCategory projectMedecineCategory, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        MedecineCategory newPT = medecineCategoryHospitalService.addMedecineCategory(projectMedecineCategory);

	        return new ResponseEntity<MedecineCategory>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<MedecineCategory> getAllMedecineCategorys()
   {
	   return medecineCategoryHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<MedecineCategory> getMedecineCategoryById(@PathVariable Long id)
   {
	   MedecineCategory medecineCategoryHospital=medecineCategoryHospitalService.findMedecineCategoryById(id);
	   return new ResponseEntity<MedecineCategory>(medecineCategoryHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteMedecineCategory(@PathVariable Long id)
   {
	   medecineCategoryHospitalService.deleteMedecineCategory(id);
	   return new ResponseEntity<String>("medecineCategoryHospital was deleted",HttpStatus.OK);
   }
	
	
}
