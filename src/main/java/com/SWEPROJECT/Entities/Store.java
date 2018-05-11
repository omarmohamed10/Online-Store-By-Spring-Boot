package com.SWEPROJECT.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String location;
	private String name;
	private String type;
	public Integer getId() {
		return id;
	}
	public Store() 
	{
		super();
		this.name="";
		this.type="";
		this.location="";
	}
	public Store(Integer id, String location, String name, String type) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
