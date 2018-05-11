package com.SWEPROJECT.Entities;

public class countdata {

	private Integer numberofbuyer;
	private Integer numberofstoreowner;
	private Integer numberofproduct;
	private Integer numberofstores;
	private Integer numberofbrands;
	private Integer  Max;
	private Integer  Min;
	private Double  Average;
	public countdata(Integer numberofbuyer, Integer numberofstoreowner, Integer numberofproduct, Integer numberofstores,
			Integer numberofbrands, Integer max, Integer min, 
			Double average) {
		super();
		this.numberofbuyer = numberofbuyer;
		this.numberofstoreowner = numberofstoreowner;
		this.numberofproduct = numberofproduct;
		this.numberofstores = numberofstores;
		this.numberofbrands = numberofbrands;
		this.Max = max;
		this.Min = min;
		this.Average = average;
	}
	public countdata() {
		super();
		this.numberofbuyer = 0;
		this.numberofstoreowner = 0;
		this.numberofproduct = 0;
		this.numberofstores = 0;
		this.numberofbrands = 0;
		this.Max = 0;
		this.Min = 0;
		this.Average = 0.0;
	}
	public	Integer getNumberofbuyer() {
		return numberofbuyer;
	}
	public	void setNumberofbuyer(Integer numberofbuyer) {
		this.numberofbuyer = numberofbuyer;
	}
	public	Integer getNumberofstoreowner() {
		return numberofstoreowner;
	}
	public	void setNumberofstoreowner(Integer numberofstoreowner) {
		this.numberofstoreowner = numberofstoreowner;
	}
	public	Integer getNumberofproduct() {
		return numberofproduct;
	}
	public	void setNumberofproduct(Integer numberofproduct) {
		this.numberofproduct = numberofproduct;
	}
	public	Integer getNumberofstores() {
		return numberofstores;
	}
	public	void setNumberofstores(Integer numberofstores) {
		this.numberofstores = numberofstores;
	}
	public	Integer getNumberofbrands() {
		return numberofbrands;
	}
	public	void setNumberofbrands(Integer numberofbrands) {
		this.numberofbrands = numberofbrands;
	}
	public	Integer getMax() {
		return Max;
	}
	public	void setMax(Integer max) {
		Max = max;
	}
	public	Integer getMin() {
		return Min;
	}
	public void setMin(Integer min) {
		Min = min;
	}
	public	Double getAverage() {
		return Average;
	}
	public void setAverage(Double average) {
		Average = average;
	}
	
}
