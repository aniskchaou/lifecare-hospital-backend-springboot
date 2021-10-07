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

import com.dev.delta.entities.Account;
import com.dev.delta.services.AccountService;


@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	@Autowired
	AccountService accountHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Account projectAccount, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Account newPT = accountHospitalService.saveOrUpdate(projectAccount);

	        return new ResponseEntity<Account>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Account> getAllAccounts()
   {
	   return accountHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Account> getAccountById(@PathVariable Long id)
   {
	   Account accountHospital=accountHospitalService.findById(id);
	   return new ResponseEntity<Account>(accountHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteAccount(@PathVariable Long id)
   {
	   accountHospitalService.delete(id);
	   return new ResponseEntity<String>("accountHospital was deleted",HttpStatus.OK);
   }
}
