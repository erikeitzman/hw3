package com.airamerica;

public class SpecialAssistance extends Product{
	private String typeOfService;

	public SpecialAssistance(String productCode, String typeOfService) {
		super(productCode);
		this.typeOfService = typeOfService;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	@Override
	public double calcFee() {
		// TODO Auto-generated method stub
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
