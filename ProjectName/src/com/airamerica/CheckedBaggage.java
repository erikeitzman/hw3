package com.airamerica;

public class CheckedBaggage extends Product{
	private Product ticket;

	public CheckedBaggage(String productCode, Product ticket) {
		super(productCode);
		this.ticket = ticket;
	}

	public Product getTicket() {
		return ticket;
	}

	public void setTicket(Product ticket) {
		this.ticket = ticket;
	}


}
