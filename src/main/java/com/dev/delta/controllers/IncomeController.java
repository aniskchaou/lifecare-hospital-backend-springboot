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

import com.dev.delta.entities.Income;
import com.dev.delta.services.IncomeService;

@RestController
@RequestMapping("/income")
@CrossOrigin
public class IncomeController {
	@Autowired
	IncomeService incomeHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Income projectIncome, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Income newPT = incomeHospitalService.addIncome(projectIncome);

	        return new ResponseEntity<Income>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Income> getAllIncomes()
   {
	   return incomeHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Income> getIncomeById(@PathVariable Long id)
   {
	   Income incomeHospital=incomeHospitalService.findIncomeById(id);
	   return new ResponseEntity<Income>(incomeHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteIncome(@PathVariable Long id)
   {
	   incomeHospitalService.deleteIncome(id);
	   return new ResponseEntity<String>("incomeHospital was deleted",HttpStatus.OK);
   }
	
	
}
