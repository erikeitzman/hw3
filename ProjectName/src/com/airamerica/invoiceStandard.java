package com.airamerica;

public class invoiceStandard {
	private Standard ticket;
	private String travelDate;
	private String noOfPasses;
	private String seat;
	private Person personCode;
	private String identityNumber;
	private String age;
	private String nationality;
	private String ticketNote;
	
	public invoiceStandard(Standard ticket, String travelDate, String noOfPasses, String seat, Person personCode,
			String identityNumber, String age, String nationality, String ticketNote) {
		super();
		this.ticket = ticket;
		this.travelDate = travelDate;
		this.noOfPasses = noOfPasses;
		this.seat = seat;
		this.personCode = personCode;
		this.identityNumber = identityNumber;
		this.age = age;
		this.nationality = nationality;
		this.ticketNote = ticketNote;
	}

	public Standard getTicket() {
		return ticket;
	}

	public void setTicket(Standard ticket) {
		this.ticket = ticket;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getNoOfPasses() {
		return noOfPasses;
	}

	public void setNoOfPasses(String noOfPasses) {
		this.noOfPasses = noOfPasses;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Person getPersonCode() {
		return personCode;
	}

	public void setPersonCode(Person personCode) {
		this.personCode = personCode;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTicketNote() {
		return ticketNote;
	}

	public void setTicketNote(String ticketNote) {
		this.ticketNote = ticketNote;
	}
	
	
}
