package com.demo.i18n.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.i18n.model.Coffee;
import com.demo.i18n.repository.CoffeeRepository;

@Service
public class CoffeeService {

	@Autowired
	CoffeeRepository coffeeRepository;

	public Coffee getCoffee(Long id) {
		
		Optional<Coffee> coffeeOption = coffeeRepository.findById(id); 
		
		return coffeeOption.isPresent() ? coffeeOption.get() : null; 
	}

	public Coffee addCoffee(Coffee coffee) {
		return coffeeRepository.save(coffee);
	}

	public boolean putCoffee(Coffee coffee) {
		
		Coffee coffeeInDb = this.getCoffee(coffee.getId());
		
		if (coffeeInDb != null) {

			coffeeInDb.setColour(coffee.getColour());
			coffeeInDb.setName(coffee.getName());
			coffeeInDb.setStrongness(coffee.getStrongness());

			coffeeRepository.save(coffeeInDb);

			return true;
		} else {
			return false;
		}

	}

	public boolean deleteCoffee(Long id) {
		
		Coffee coffeeInDb = this.getCoffee(id);
		
		if (coffeeInDb != null) {

			coffeeRepository.delete(coffeeInDb);

			return true;
		} else {
			return false;
		}
	}

}
