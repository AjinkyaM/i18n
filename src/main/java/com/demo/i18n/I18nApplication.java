package com.demo.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.i18n.model.Coffee;
import com.demo.i18n.service.CoffeeService;

@SpringBootApplication
public class I18nApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(I18nApplication.class);
	
	@Autowired
	CoffeeService coffeeService;

	public static void main(String[] args) {
		SpringApplication.run(I18nApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*coffeeService.addCoffee(new Coffee("coffee1", "colour1"));
		coffeeService.addCoffee(new Coffee("coffee2", "colour2"));
		coffeeService.addCoffee(new Coffee("coffee3", "colour3"));
		coffeeService.addCoffee(new Coffee("coffee4", "colour4"));
		coffeeService.addCoffee(new Coffee("coffee5", "colour5"));*/
	}
}
