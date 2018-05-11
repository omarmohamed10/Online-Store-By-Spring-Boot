package com.SWEPROJECT.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String BrandName;
	private String BrandCategory;

	public Brand() {
		super();
		this.BrandName="";
		this.BrandCategory="";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String BrandName) {
		this.BrandName = BrandName;
	}

	public String getBrandCategory() {
		return BrandCategory;
	}

	public void setBrandCategory(String BrandCategory) {
		this.BrandCategory = BrandCategory;
	}

	public Brand(Integer id, String BrandName, String BrandCategory) {
		super();
		this.id = id;
		this.BrandName = BrandName;
		this.BrandCategory = BrandCategory;
	}
	
	
}
