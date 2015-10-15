package com.airamerica.interfaces;

public interface ProductInterface {

	double calcFee(Double quantity, Double distance);
	double calcTax(Double quantity, Double distance);
	double calcSub(Double quantity, Double distance);
	double calcTotal(Double quantity, Double distance);
}
