package com.airamerica.interfaces;

public interface ProductInterface {

	double calcFee(int quantity, String ticketCode);
	double calcTax(int quantity, String ticketCode);
	double calcSub(int quantity, String ticketCode);
	double calcTotal(int quantity, String ticketCode);
}
