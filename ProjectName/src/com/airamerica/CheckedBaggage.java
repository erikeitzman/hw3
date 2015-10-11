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
	public double calcSub(int quantity, String ticketCode) {
		return 25+(quantity-1)*35;
	}

	@Override
	public double calcTax(int quantity, String ticketCode) {
		return calcSub(quantity, ticketCode)*.04;
	}

	@Override
	public double calcTotal(int quantity, String ticketCode) {
		return calcSub(quantity, ticketCode)+calcTax(quantity, ticketCode);
	}
}
