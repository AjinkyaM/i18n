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
import com.demo.i18n.service.CoffeeJsonService;
import com.google.gson.Gson;

@RestController
public class CoffeeJsonConroller {
	
	private static final Logger logger = LoggerFactory.getLogger(CoffeeConroller.class);
	
	@Autowired
	CoffeeJsonService coffeeJsonService;
	
	private Gson gson = new Gson();
	
	@GetMapping("/coffeejson/{id}")
	public ResponseEntity<String> getCoffee(@PathVariable("id") Long id){
		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(coffeeJsonService.getCoffee(id));
	    
	    logger.info("Response: {}", response);
	    return response;
	}
	
	@PostMapping( value = "/coffeejson" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> postCoffee(@RequestBody Coffee coffee){
		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(coffeeJsonService.addCoffee(coffee).getJsonText());
	    
	    logger.info("Response: {}", response);
	    return response;
	}
	
	@PutMapping("/coffeejson/{id}")
	public ResponseEntity<String> putCoffee(@PathVariable Long id, @RequestBody Coffee coffee){
		
		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(gson.toJson(coffeeJsonService.putCoffee(id, coffee)));
	    
	    logger.info("Response: {}", response);
	    return response;
	}
	
	@DeleteMapping("/coffeejson/{id}")
	public ResponseEntity<String> deleteCoffee(@PathVariable("id") Long id){

		ResponseEntity<String> response = null;
		BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
	    builder.contentType(MediaType.APPLICATION_JSON);
	    
	    response = builder.body(gson.toJson(coffeeJsonService.deleteCoffee(id)));
	    
	    logger.info("Response: {}", response);
	    return response;
	
	}

	
}
