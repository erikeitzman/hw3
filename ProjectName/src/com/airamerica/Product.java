package com.airamerica;

import com.airamerica.interfaces.ProductInterface;

public abstract class Product implements ProductInterface{
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
