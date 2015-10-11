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

	public double calcTax(int quantity, String ticketCode) {
		return calcSub(quantity, ticketCode)*.04;
	}

	public double calcFee(int quantity, String ticketCode) {
		return 0;
	}

	public double calcTotal(int quantity, String ticketCode) {
		return calcSub(quantity, ticketCode)+calcTax(quantity, ticketCode);
	}
	
	public double calcSub(int quantity, String ticketCode){
		return 0;
	}
	
}
