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

import com.dev.delta.entities.Inventory;
import com.dev.delta.services.InventoryService;


@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
	@Autowired
	InventoryService inventoryHospitalService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Inventory projectInventory, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Inventory newPT = inventoryHospitalService.addInventory(projectInventory);

	        return new ResponseEntity<Inventory>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Inventory> getAllInventorys()
   {
	   return inventoryHospitalService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id)
   {
	   Inventory inventoryHospital=inventoryHospitalService.findInventoryById(id);
	   return new ResponseEntity<Inventory>(inventoryHospital,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteInventory(@PathVariable Long id)
   {
	   inventoryHospitalService.deleteInventory(id);
	   return new ResponseEntity<String>("inventoryHospital was deleted",HttpStatus.OK);
   }
	
	
}
