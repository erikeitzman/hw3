package com.airamerica;

import com.airamerica.utils.Haversine;
import com.airamerica.utils.*;

public class Insurance extends Product{
	
	private String name;
	private String ageClass;
	private Double costPerMile;
	public Insurance(String productCode, String name, String ageClass, Double costPerMile) {
		super(productCode);
		this.name = name;
		this.ageClass = ageClass;
		this.costPerMile = costPerMile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAgeClass() {
		return ageClass;
	}
	public void setAgeClass(String ageClass) {
		this.ageClass = ageClass;
	}
	public Double getCostPerMile() {
		return costPerMile;
	}
	public void setCostPerMile(Double costPerMile) {
		this.costPerMile = costPerMile;
	}

	
	public double calcTax() {
		
		return this.calcSub()*0.04;
	}
	
	public double calcSub(Standard ticket) {
		// TODO Auto-generated method stub
		return this.getCostPerMile() * ticket.distance();
	}

	public double calcTotal() {
		
		return this.calcSub() + this.calcTax();
	}
	
	public double calcFee() {
		
		 return 0;
	}
	
	public double calcSub() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
