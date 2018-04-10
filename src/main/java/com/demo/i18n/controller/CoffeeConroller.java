package com.demo.i18n.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.i18n.model.Coffee;
import com.demo.i18n.service.CoffeeService;
import com.google.gson.Gson;

@RestController
public class CoffeeConroller {
	private static final Logger logger = LoggerFactory.getLogger(CoffeeConroller.class);
	
	@Autowired
	CoffeeService coffeeService;
	
	private Gson gson = new Gson();
	
	@GetMapping("/coffee/{id}")
	public ResponseEntity<String> getCoffee(@PathVariable("id") Long id){
		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(gson.toJson(coffeeService.getCoffee(id)));
	    
	    logger.info("Response: {}", response);
	    return response;
	}
	
	@PostMapping("/coffee")
	public ResponseEntity<String> postCoffee(@RequestBody Coffee coffee){
		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(gson.toJson(coffeeService.addCoffee(coffee)));
	    
	    logger.info("Response: {}", response);
	    return response;
	}
	
	@PutMapping("/coffee")
	public ResponseEntity<String> putCoffee(@RequestBody Coffee coffee){
		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(gson.toJson(coffeeService.putCoffee(coffee)));
	    
	    logger.info("Response: {}", response);
	    return response;
	}
	
	@DeleteMapping("/coffee/{id}")
	public ResponseEntity<String> deleteCoffee(@PathVariable("id") Long id){

		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(gson.toJson(coffeeService.deleteCoffee(id)));
	    
	    logger.info("Response: {}", response);
	    return response;
	
	}
	
	

}
