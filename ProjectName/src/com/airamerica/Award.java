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
	
}
