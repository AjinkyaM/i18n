package com.demo.i18n.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.i18n.model.Coffee;
import com.demo.i18n.model.CoffeeJson;
import com.demo.i18n.repository.CoffeeJsonRepository;
import com.google.gson.Gson;

@Service
public class CoffeeJsonService {
	
	@Autowired
	CoffeeJsonRepository coffeeJsonRepository;
	
	private Gson gson = new Gson();
	
	public String getCoffee(Long id) {
		
		Optional<CoffeeJson> coffeeOption = coffeeJsonRepository.findById(id); 
		
		return coffeeOption.isPresent() ? coffeeOption.get().getJsonText() : null; 
	}

	public CoffeeJson addCoffee(Coffee coffee) {
		
		CoffeeJson coffeeJson = new CoffeeJson(gson.toJson(coffee));
		return coffeeJsonRepository.save(coffeeJson);
		
	}

	public boolean putCoffee(Long id, Coffee coffee) {
		
		Optional<CoffeeJson> coffeeOption = coffeeJsonRepository.findById(id);
		
		if (coffeeOption.isPresent()) {

			CoffeeJson coffeeJsonDb = coffeeOption.get();
			
			coffeeJsonDb.setJsonText(gson.toJson(coffee));

			coffeeJsonRepository.save(coffeeJsonDb);
			
			return true;
			
		} else {
			
			return false;
		}

	}

	public boolean deleteCoffee(Long id) {
		
		Optional<CoffeeJson> coffeeOption = coffeeJsonRepository.findById(id);
		
		if (coffeeOption.isPresent()) {

			coffeeJsonRepository.delete(coffeeOption.get());

			return true;
			
		} else {
			
			return false;
		}
	}


}
