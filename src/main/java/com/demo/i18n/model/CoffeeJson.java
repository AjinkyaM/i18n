package com.demo.i18n.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="coffee_json")
public class CoffeeJson {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name = "json_text")
	private String jsonText;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJsonText() {
		return jsonText;
	}

	public void setJsonText(String jsonText) {
		this.jsonText = jsonText;
	}
	
	public CoffeeJson() {
	}

	public CoffeeJson(String jsonText) {
		super();
		this.jsonText = jsonText;
	}



}
