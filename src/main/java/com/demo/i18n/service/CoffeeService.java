package com.demo.i18n.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.i18n.model.Coffee;
import com.demo.i18n.repository.CoffeeRepository;
import com.google.gson.JsonElement;

@Service
public class CoffeeService {

	private static final Logger logger = LoggerFactory.getLogger(CoffeeService.class);

	@Autowired
	CoffeeRepository coffeeRepository;

	public Coffee getCoffee(Long id) {
		return coffeeRepository.findOne(id);
	}

	public Coffee addCoffee(Coffee coffee) {
		return coffeeRepository.saveAndFlush(coffee);
	}

	public boolean putCoffee(Coffee coffee) {
		Coffee coffeeInDb = coffeeRepository.findOne(coffee.getId());
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
		Coffee coffeeInDb = coffeeRepository.findOne(id);
		if (coffeeInDb != null) {

			coffeeRepository.delete(coffeeInDb);

			return true;
		} else {
			return false;
		}
	}

}
