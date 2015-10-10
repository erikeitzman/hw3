package com.airamerica;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	private String InvoiceCode;
	private Customer customer;
	private Person person;	
	private String invoiceDate;	
	private List<Product> productList;
	public Invoice(String invoiceCode, Customer customer, Person person, String invoiceDate) {
		super();
		InvoiceCode = invoiceCode;
		this.customer = customer;
		this.person = person;
		this.invoiceDate = invoiceDate;
		this.productList = new ArrayList<Product>();
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
	public void addProduct(Product product){
		this.productList.add(product);
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}