package com.SWEPROJECT.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product 
{	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String category;
	private Integer price;
	private String Location;
	private Integer amout;
	private Integer deleted;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Integer getAmout() {
		return amout;
	}
	public void setAmout(Integer amout) {
		this.amout = amout;
	}
	public Product(Integer id,String name, String category, Integer price, String location, Integer amout) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.Location = location;
		this.deleted=0;
		this.amout = amout;
	}
	public Product() {
		super();
		this.id = 0;
		this.deleted=0;
		this.name ="";
		this.category = "";
		this.price = 0;
		this.Location = "";
		this.amout = 0;
	}
	public int sum(int x,int y) {
		return x+y;
	}
	
}
