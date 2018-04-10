package com.demo.i18n.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coffee {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String colour;
    private Integer strongness;
    
    public Long getId() {
		return id;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Integer getStrongness() {
		return strongness;
	}

	public void setStrongness(Integer strongness) {
		this.strongness = strongness;
	}

	protected Coffee() {}

    public Coffee(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', colour='%s']",
                id, name, colour);
    }

}