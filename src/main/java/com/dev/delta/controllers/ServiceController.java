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

import com.dev.delta.entities.Service;
import com.dev.delta.services.ServiceService;


@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceController {
	@Autowired
	ServiceService serviceService;
	
	
	@PostMapping("/create")
	 public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Service projectService, BindingResult result){

	    if(result.hasErrors()){
	            Map<String, String> errorMap = new HashMap<String,String>();

	            for(FieldError error: result.getFieldErrors()){
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }
	            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	        }
          
	        Service newPT = serviceService.saveOrUpdate(projectService);

	        return new ResponseEntity<Service>(newPT, HttpStatus.CREATED);
	    }
	
	
	
   @GetMapping("/all")
   public Iterable<Service> getAllServices()
   {
	   return serviceService.findAll();
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Service> getServiceById(@PathVariable Long id)
   {
	   Service service=serviceService.findById(id);
	   return new ResponseEntity<Service>(service,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteService(@PathVariable Long id)
   {
	   serviceService.delete(id);
	   return new ResponseEntity<String>("service was deleted",HttpStatus.OK);
   }
}
