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

	@Override
	public double calcFee() {
		
		return 0;
	}

	@Override
	public double calcTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcSub() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcTotal() {
		// TODO Auto-generated method stub
		return 0;
	}


}
