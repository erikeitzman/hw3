package com.airamerica;

public class Refreshment extends Product{
	
	private String name;
	private Double cost;
	
	public Refreshment(String productCode, String name, Double cost) {
		super(productCode);
		this.name = name;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	

	
}