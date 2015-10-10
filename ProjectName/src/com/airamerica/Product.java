package com.airamerica;

public abstract class Product {
	private String productCode;

	public Product(String productCode) {
		super();
		this.productCode = productCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
}
