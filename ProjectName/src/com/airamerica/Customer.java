package com.airamerica;

public class Customer {
//Class for Customers	
	
	private String customerCode;
	private String type;
	private Person primaryContact;
	private String name;
	private int airlineMiles;

	public Customer(String customerCode, String type, Person primaryContact, String name) {
		this.customerCode = customerCode;
		this.type = type;
		this.primaryContact = primaryContact;
		this.name = name;
		this.airlineMiles = 0;
	}

	//Eclipse getters and setters
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Person primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAirlineMiles() {
		return airlineMiles;
	}

	public void setAirlineMiles(int airlineMiles) {
		this.airlineMiles = airlineMiles;
	}
	
	
	
}
