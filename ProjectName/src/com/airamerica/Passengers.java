package com.airamerica;

public class Passengers {
	private String seatNumber;
	private Person person;
	private String Id;
	private int age;
	private String Nationality;
	public Passengers(String seatNumber, Person person, String id, int age, String nationality) {
		super();
		this.seatNumber = seatNumber;
		this.person = person;
		Id = id;
		this.age = age;
		Nationality = nationality;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	

}
