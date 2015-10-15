package com.airamerica;


import java.util.ArrayList;
import java.util.List;

import unl.cse.assignments.DataConverter;

public class Invoice  {
	private String InvoiceCode;
	private Customer customer;
	private Person person;
	private String invoiceDate;
	private ArrayList<SoldProduct> productList;
	private ArrayList<Passengers> passengerList;

	public Invoice(String invoiceCode, Customer customer, Person person, String invoiceDate) {
		InvoiceCode = invoiceCode;
		this.customer = customer;
		this.person = person;
		this.invoiceDate = invoiceDate;
		this.productList = new ArrayList<SoldProduct>();
		this.passengerList = new ArrayList<Passengers>();
	}
	
	public String getInvoiceCode() {
		return InvoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		InvoiceCode = invoiceCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public ArrayList<SoldProduct> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<SoldProduct> productList) {
		this.productList = productList;
	}

	public ArrayList<Passengers> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(ArrayList<Passengers> passengerList) {
		this.passengerList = passengerList;
	}
	
	public void addPassenger(Passengers passenger){
		this.passengerList.add(passenger);
	}
	
	public void addSoldProduct(SoldProduct soldProduct){
		this.productList.add(soldProduct);
	}
	
	public Boolean flightOnInvoice(){
		for (int i = 0; i < this.getProductList().size(); i++){
			if (this.getProductList().get(i).getProduct().getClass().getName().equals("com.airamerica.Standard") || this.getProductList().get(i).getProduct().getClass().getName().equals("com.airamerica.Offseason") || this.getProductList().get(i).getProduct().getClass().getName().equals("com.airamerica.Award")){
				return true;
			}
		}
		return false;
	}
	
	public Boolean flightBool(int i){
			if (this.getProductList().get(i).getProduct().getClass().getName().equals("com.airamerica.Standard") || this.getProductList().get(i).getProduct().getClass().getName().equals("com.airamerica.Offseason") || this.getProductList().get(i).getProduct().getClass().getName().equals("com.airamerica.Award")){
				return true;
			}else{
				return false;
			}
	}
	
	public void printFlightInfo(){
		for (int i = 0; i < this.getProductList().size(); i++){
			if(flightBool(i)){
				for(int j = 0; j<this.getPassengerList().size(); j++){
					if(this.getPassengerList().get(j).getFlight().equals(this.getProductList().get(i).getProduct().getProductCode())){
						System.out.println(this.getPassengerList().get(j).getPerson().getLastName()+", "+this.getPassengerList().get(j).getPerson().getFirstName()+", "+this.getPassengerList().get(j).getAge()+", "+this.getPassengerList().get(j).getSeatNumber());
					}
				}
			}
		}
	}
	
//	public void addSoldProduct(Product productArr[], String productString){
//		String array3[] = productString.split(":");
//		Double quantity = 1.0;
//		Double distance = null;
//		if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Insurance" || DataConverter.findClass(productArr, array3[0]) == "com.airamerica.CheckedBaggage" || DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Refreshment"){
//			quantity = Double.parseDouble(array3[1]);
//			if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Insurance"){
//				distance = DataConverter.findTicket(productArr, array3[2]).distance();
//			}
//		}else if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.SpecialAssistance"){
//			quantity = 1.0;
//		}else{
//			quantity = Double.parseDouble(array3[2]);
//		}
//	}
//	
//	public Double CalculateSub(List<Product> productList, Double quantityDistance[], int index){
//		return productList.get(index).calcSub(quantityDistance[0], quantityDistance[1]);
//	}
//	
//	public Double CalculateTax(List<Product> productList, Double quantityDistance[], int index){
//		return productList.get(index).calcTax(quantityDistance[0], quantityDistance[1]);
//	}
//	
//	public Double CalculateTotal(List<Product> productList, Double quantityDistance[], int index){
//		return productList.get(index).calcTax(quantityDistance[0], quantityDistance[1])+productList.get(index).calcSub(quantityDistance[0], quantityDistance[1]);
//	}
//			if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Refreshment" && flight == true){
//				subtotal = .95*productList.get(j).calcSub(quantity, distance);
//				taxes = productList.get(j).calcTax(quantity, distance);
//				finalsub = subtotal + finalsub;
//				finaltax = taxes + finaltax;
//			}else{
//				subtotal = productList.get(j).calcSub(quantity, distance);
//				taxes = productList.get(j).calcTax(quantity, distance);
//				finalsub = subtotal + finalsub;
//				finaltax = taxes + finaltax;
//		}	

//	public void getCostSummary(Product productArr[], String productString){
//		Double quantityDistance[] = this.getQuantityDistance(productArr, productString);
//		for(int i = 0; i<this.getProductList().size(); i++){
//			System.out.printf("%f.2   %f.2", this.CalculateTax(this.getProductList(), quantityDistance, i), this.CalculateSub(this.getProductList(), quantityDistance, i));
//		}
//	}
}
	
//	public void flightinformation(){
//		//TODO: get day and date
//		System.out.printf("%s,%s %15s %15s %30s,%s %25s,%s %30s\n ", "Day","Date", standard.getFlightNo(), standard.getFlightClass(), standard.getDepartureCity().getAddress().getCity(),standard.getDepartureCity().getAddress().getState(), standard.getArrivalCity().getAddress().getCity(), standard.getArrivalCity().getAddress().getState(), standard.getAircraftType() );
//		System.out.printf("                                                              (%s) %3s                  (%s) %3s\n", standard.getDepartureCity().getAirportCode(), standard.getDepartureDateTime(), standard.getArrivalCity().getAirportCode(), standard.getArrivalDateTime());
//		//System.out.println("               Traveller               Age     Seat NO.");
//		
//	}


//public void printSummary(int i){
//	String lastName1 = person.getLastName();
//	String firstName1 = person.getFirstName();
//	
//	if (i == 1){
//		lastName1 = "ONLINE";
//		firstName1 = "Null";
//	
//	}
//	String name = lastName1 +", " + firstName1;
//	System.out.printf("%s%30s[%2s]%22s% 25.2f %10.2f %10.2f   %10.2f  %10.2f\n",this.getInvoiceCode(), customer.getName(), customer.getType(), name, this.getFinalsub(), this.getFee(), this.getFinaltax(), this.getDiscount(), this.getFinalsub()+this.getDiscount()+this.getFee()+this.getFinaltax());
//	
//}

