package com.airamerica;

import com.airamerica.utils.Haversine;

public class Standard extends Product {
	private Airport departureCity;
	private Airport arrivalCity;
	private String departureDateTime;
	private String arrivalDateTime;
	private String flightNo;
	private String flightClass;
	private String aircraftType;
	private Double costPerMile;
	
	public Standard(String productCode, Airport departureCity, Airport arrivalCity, String departureDateTime,
			String arrivalDateTime, String flightNo, String flightClass, String aircraftType) {
		super(productCode);
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.flightNo = flightNo;
		this.flightClass = flightClass;
		this.aircraftType = aircraftType;
		if (this.flightClass.equals("BC")){
			this.costPerMile = 0.5;
		}else if(this.flightClass.equals("EP")){
			this.costPerMile = 0.2;
		}else{
			this.costPerMile = 0.15;
		}
	}

	public Airport getDeparturecity() {
		return departureCity;
	}

	public void setDeparturecity(Airport departureCity) {
		this.departureCity = departureCity;
	}

	public Airport getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(Airport arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public Double getCostPerMile() {
		return costPerMile;
	}

	public void setCostPerMile(Double costPerMile) {
		this.costPerMile = costPerMile;
	}
	
	public double distance(){
		return Haversine.getMiles(this.arrivalCity.getLatitudes(), this.arrivalCity.getLongitudes(), this.departureCity.getLatitudes(), this.departureCity.getLongitudes());
	}

	public double calcFee() {
		return 0;
	}

	public double calcTax() {
		return this.calcSub()*.075+4+5.6+this.arrivalCity.getPassengerFacilityFee();
	}

	
	public double calcSub() {
		return this.distance()*this.costPerMile;
		}

	public double calcTotal() {
		return this.calcTax()+this.calcSub();
	}
}
