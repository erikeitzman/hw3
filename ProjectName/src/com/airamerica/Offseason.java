package com.airamerica;

public class Offseason extends Standard{
	
	private String seasonStartDate;
	private String seasonEndDate;
	private double rebate;
	
	public Offseason(String productCode, Airport departurecity, Airport arrivalCity, String departureDateTime,
			String arrivalDateTime, String flightNo, String flightClass, String aircraftType,
			String seasonStartDate, String seasonEndDate, double rebate) {
		super(productCode, departurecity, arrivalCity, departureDateTime, arrivalDateTime, flightNo, flightClass,
				aircraftType);
		this.seasonStartDate = seasonStartDate;
		this.seasonEndDate = seasonEndDate;
		this.rebate = rebate;
	}

	public String getSeasonStartDate() {
		return seasonStartDate;
	}

	public void setSeasonStartDate(String seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}

	public String getSeasonEndDate() {
		return seasonEndDate;
	}

	public void setSeasonEndDate(String seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	@Override
	public double calcFee(int quantity, String ticketCode){
		return 30.0;
	}
	
	@Override
	public double calcTax(int quantity, String ticketCode) {
		return calcSub(quantity, ticketCode)*.075+quantity*(4+5.6+this.getArrivalCity().getPassengerFacilityFee());
	}

	@Override
	public double calcSub(int quantity, String ticketCode) {
		return (20+quantity*(1-this.getRebate())*this.distance()*this.getCostPerMile());
		}

	@Override
	public double calcTotal(int quantity, String ticketCode) {
		return this.calcTax(quantity, ticketCode)+this.calcSub(quantity, ticketCode);
	}

}
