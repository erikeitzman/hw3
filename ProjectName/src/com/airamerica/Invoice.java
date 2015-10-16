package com.airamerica;


import java.util.ArrayList;
import java.util.List;

import com.airamerica.utils.StandardUtils;

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
	
	public void printProductFares(){
		for (int i = 0; i < this.getProductList().size(); i++){
			Double quantity = this.getProductList().get(i).getQuantity();
			Double misc = this.getProductList().get(i).getMisc();
			this.getProductList().get(i).getProduct().printFare(quantity, misc);
		}
	}
	
	public void printSummary(){
		String name = this.person.getLastName() +", " + this.person.getFirstName();
		String customerName = this.getCustomer().getName()+"["+this.getCustomer().getType()+"]";
		System.out.printf("%-10s %-45s %-25s $%11.2f $%11.2f $%11.2f $%11.2f $%11.2f\n",this.getInvoiceCode(), customerName, name, this.FinalSub(), this.Fee(), this.FinalTax(), this.Discount(), this.FinalSub()+this.Discount()+this.Fee()+this.FinalTax());
	}
	
	public Double FinalSub(){
		Double sub = 0.0;
		for (int i=0; i<this.getProductList().size(); i++){
			Double quantity = this.getProductList().get(i).getQuantity();
			Double misc = this.getProductList().get(i).getMisc();
			sub = sub + this.getProductList().get(i).getProduct().calcSub(quantity, misc);
		}
		return sub;
	}
	
	public Double FinalTax(){
		Double tax = 0.0;
		for (int i=0; i<this.getProductList().size(); i++){
			Double quantity = this.getProductList().get(i).getQuantity();
			Double misc = this.getProductList().get(i).getMisc();
			tax = tax + this.getProductList().get(i).getProduct().calcTax(quantity, misc);
		}
		return tax;
	}
	
	public Double Discount(){
		Double discount = 0.0;
		if(this.getCustomer().getType().equals("Corporate")){
			discount = (this.FinalSub()) * .12*(-1);
		}else if(this.getCustomer().getType().equals("Government")){
			discount = this.FinalTax()*(-1);
		}
		return discount;
	}
	
	public Double Fee(){
		Double fee = 0.0;
		if(this.getCustomer().getType().equals("Corporate")){
			fee = 40.0;
		}
		return fee;
	}
	
	public void printFlightInformation(){
		System.out.println("Individual Invoice Detail Reports");
		System.out.println("==================================================");
		System.out.println("Invoice "+this.getInvoiceCode());
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("AIR-AMERICA                                                          PNR");
		System.out.printf("%s: %3s %49s\n","ISSUE DATE", this.getInvoiceDate(), StandardUtils.generatePNR());
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("FLIGHT INFORMATION");
		System.out.println("Day, Date       Flight     Class   DepartureCity and Time        ArrivalCity and Time      Aircraft");
		for (int i = 0; i < this.getProductList().size(); i++){
			if(flightBool(i)){
				Standard tempTicket = (Standard) this.getProductList().get(i).getProduct();
				System.out.printf("%-15s %-10s %-6s %-30s %-25s %-10s\n", "Fri,08Jan16", tempTicket.getFlightNo(), tempTicket.getFlightClass(), tempTicket.getDepartureCity().getAddress().cityState(), tempTicket.getArrivalCity().getAddress().cityState(), tempTicket.getAircraftType());
				System.out.printf("%-33s %-30s %-35s\n","", "ord ayy", "phx ayylma");
				System.out.printf("%15s %-20s %-8s %-6s\n", "", "Traveller", "Age", "SeatNo");
				for(int j = 0; j<this.getPassengerList().size(); j++){
					if(this.getPassengerList().get(j).getFlight().equals(this.getProductList().get(i).getProduct().getProductCode())){
						System.out.printf("%15s %-20s %-8s %-6s\n", "",this.getPassengerList().get(j).getPerson().getLastName()+", "+this.getPassengerList().get(j).getPerson().getFirstName(), this.getPassengerList().get(j).getAge(), this.getPassengerList().get(j).getSeatNumber());
//						System.out.println(this.getPassengerList().get(j).getPerson().getLastName()+", "+this.getPassengerList().get(j).getPerson().getFirstName()+", "+this.getPassengerList().get(j).getAge()+", "+this.getPassengerList().get(j).getSeatNumber());
					}
				}
			}
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
	
//	if (b.getType().equals("Corporate")){
//	discount = (finalsub) * .12*(-1);
//	fee = 40.0;
//}else if (b.getType().equals("Government")){
//	discount = finaltax*(-1);
//}
//	public void FinalTotal(){
//		Double total = 0.0;
//		for (int i=0; i<this.getProductList().size(); i++){
//			Double quantity = this.getProductList().get(i).getQuantity();
//			Double misc = this.getProductList().get(i).getMisc();
//			total = total + this.getProductList().get(i).getProduct().calcTotal(quantity, misc);
//		}
//	}
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

