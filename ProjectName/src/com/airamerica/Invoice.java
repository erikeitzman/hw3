package com.airamerica;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	private String InvoiceCode;
	private Customer customer;
	private Person person;	
	private String invoiceDate;	
	private List<Product> productList;
	private double finalsub;
	private double finaltax;
	private double fee;
	private double discount;

	public Invoice(String invoiceCode, Customer customer, Person person, String invoiceDate, List<Product> productList,
			double finalsub, double finaltax, double fee, double discount) {
		super();
		InvoiceCode = invoiceCode;
		this.customer = customer;
		this.person = person;
		this.invoiceDate = invoiceDate;
		this.productList = productList;
		this.finalsub = finalsub;
		this.finaltax = finaltax;
		this.fee = fee;
		this.discount = discount;
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
		String result = String.format("%1$s %2$30s [3$%s] %4$20s %5$10.2f %6$10.2f %7$10.2f %8$10.2f         %.2f\n",this.getInvoiceCode(), customer.getName(), customer.getType(), name, this.getFinalsub(), this.getFee(), this.getFinaltax(), this.getDiscount(), this.getFinalsub()+this.getDiscount()+this.getFee()+this.getFinaltax());
		System.out.print(result);
	}
	
}
