package com.airamerica;

public class Standard extends Product {
	private Airport departurecity;
	private Airport arrivalCity;
	private String departureDateTime;
	private String arrivalDateTime;
	private String flightNo;
	private String flightClass;
	private String aircraftType;
	private Double costPerMile;
	
	public Standard(String productCode, Airport departurecity, Airport arrivalCity, String departureDateTime,
			String arrivalDateTime, String flightNo, String flightClass, String aircraftType) {
		super(productCode);
		this.departurecity = departurecity;
		this.arrivalCity = arrivalCity;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.flightNo = flightNo;
		this.flightClass = flightClass;
		this.aircraftType = aircraftType;
		this.costPerMile = (double) 1;
	}

	public Airport getDeparturecity() {
		return departurecity;
	}

	public void setDeparturecity(Airport departurecity) {
		this.departurecity = departurecity;
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


}
