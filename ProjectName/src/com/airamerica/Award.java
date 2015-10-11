package com.airamerica;

public class Award extends Standard{

	private Double redemptionFee;
	private Double pointsPerMile;
	
	public Award(String productCode, Airport departurecity, Airport arrivalCity, String departureDateTime,
			String arrivalDateTime, String flightNo, String flightClass, String aircraftType, Double pointsPerMile) {
		super(productCode, departurecity, arrivalCity, departureDateTime, arrivalDateTime, flightNo, flightClass,
				aircraftType);
		this.redemptionFee = (double) 30;
		this.pointsPerMile = pointsPerMile;
	}

	public Double getRedemptionFee() {
		return redemptionFee;
	}

	public void setRedemptionFee(Double redemptionFee) {
		this.redemptionFee = redemptionFee;
	}

	public Double getPointsPerMile() {
		return pointsPerMile;
	}

	public void setPointsPerMile(Double pointsPerMile) {
		this.pointsPerMile = pointsPerMile;
	}
	
	public Double getRewardsCost(){
		return this.getPointsPerMile()*this.distance();
	}
	
	@Override
	public double calcTax(int quantity, String ticketCode) {
		return 30*.075+quantity*(4+5.6+this.getArrivalCity().getPassengerFacilityFee());
	}

	@Override
	public double calcSub(int quantity, String ticketCode) {
		return 30;
		}

	@Override
	public double calcTotal(int quantity, String ticketCode) {
		return this.calcTax(quantity, ticketCode)+this.calcSub(quantity, ticketCode);
	}
}
