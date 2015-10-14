package com.airamerica;


import java.util.List;

public class Invoice  {
	private String InvoiceCode;
	private Customer customer;
	private Person person;
	private Standard standard;
	private String invoiceDate;	
	private List<Product> productList;
	private double finalsub;
	private double finaltax;
	private double fee;
	private double discount;

	public Invoice(String invoiceCode, Customer customer, Person person, Standard standard, String invoiceDate, List<Product> productList,
			double finalsub, double finaltax, double fee, double discount) {
		InvoiceCode = invoiceCode;
		this.customer = customer;
		this.person = person;
		this.invoiceDate = invoiceDate;
		this.productList = productList;
		this.finalsub = finalsub;
		this.finaltax = finaltax;
		this.fee = fee;
		this.discount = discount;
		this.standard = standard;
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
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public double getFinalsub() {
		return finalsub;
	}
	public void setFinalsub(double finalsub) {
		this.finalsub = finalsub;
	}
	public double getFinaltax() {
		return finaltax;
	}
	public void setFinaltax(double finaltax) {
		this.finaltax = finaltax;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public void printSummary(int i){
		String lastName1 = person.getLastName();
		String firstName1 = person.getFirstName();
		
		if (i == 1){
			lastName1 = "ONLINE";
			firstName1 = "Null";
		
		}
		String name = lastName1 +", " + firstName1;
		System.out.printf("%s%30s[%2s]%22s% 25.2f %10.2f %10.2f   %10.2f  %10.2f\n",this.getInvoiceCode(), customer.getName(), customer.getType(), name, this.getFinalsub(), this.getFee(), this.getFinaltax(), this.getDiscount(), this.getFinalsub()+this.getDiscount()+this.getFee()+this.getFinaltax());
		
	}
	
	public void flightinformation(){
		//TODO: get day and date
		System.out.printf("%s,%s %15s %15s %30s,%s %25s,%s %30s\n ", "Day","Date", standard.getFlightNo(), standard.getFlightClass(), standard.getDepartureCity().getAddress().getCity(),standard.getDepartureCity().getAddress().getState(), standard.getArrivalCity().getAddress().getCity(), standard.getArrivalCity().getAddress().getState(), standard.getAircraftType() );
		System.out.printf("                                                              (%s) %3s                  (%s) %3s\n", standard.getDepartureCity().getAirportCode(), standard.getDepartureDateTime(), standard.getArrivalCity().getAirportCode(), standard.getArrivalDateTime());
		//System.out.println("               Traveller               Age     Seat NO.");
		
	}
}
