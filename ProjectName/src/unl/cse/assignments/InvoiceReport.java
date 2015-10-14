package unl.cse.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.airamerica.Airport;
import com.airamerica.Customer;
import com.airamerica.Invoice;
import com.airamerica.Person;
import com.airamerica.Product;
import com.airamerica.Standard;

/* Assignment 3,5 and 6 (Project Phase-II,IV and V) */

public class InvoiceReport {

	private String generateSummaryReport() {
		String q;
		StringBuilder sb = new StringBuilder();

		q= sb.append("Executive Summary Report\n").append("=========================\n").append("Invoice                    Customer                        Salesperson                Subtotal       Fees     Taxes       Discount   Total" ).toString();
		System.out.println(q);
		Double taxes = 0.0;
		Double subtotal = 0.0;
		Double finalsub = 0.0;
		Double finaltax = 0.0;
		Double discount = 0.0;
		Double fee = 0.0;
		Airport airportArr[] = new Airport[1];
		Person personArr[] = new Person[1];
		Customer customerArr[] = new Customer[1];
		Product productArr[] = new Product[1];
		Scanner s = DataConverter.scanFileIn("data/Invoices.dat");
		Invoice invoiceArr[] = new Invoice[Integer.parseInt(s.nextLine())];
		airportArr = DataConverter.airportToArray();
		personArr = DataConverter.personToArray();
		customerArr = DataConverter.customersToArray(personArr);
		productArr = DataConverter.productsToArray(airportArr);
		for (int i = 0; i < invoiceArr.length; i++){
			int commas = 0;
			subtotal = 0.0;
			taxes = 0.0;
			finalsub = 0.0;
			finaltax = 0.0;
			discount = 0.0;
			fee = 0.0;
			String line = s.nextLine();
			String array[] = line.split(";");
			String array2[] = array[4].split(",");

			List<Product> productList = new ArrayList<Product>();
			Customer b =  customerArr[0];
			Person c = personArr[0];
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == ','){
					commas++;
				}
			}
			boolean flight = false;
			for (int j = 0; j<=commas; j++){
				String array3[] = array2[j].split(":");
				int quantity = 1;
				String distance = null;
				productList.add(DataConverter.findTicket(productArr, array3[0]));
				if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Insurance" || DataConverter.findClass(productArr, array3[0]) == "com.airamerica.CheckedBaggage" || DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Refreshment"){
					quantity = Integer.parseInt(array3[1]);
					if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Insurance"){
						distance = String.valueOf(DataConverter.findTicket(productArr, array3[2]).distance());

					}
				}else if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.SpecialAssistance"){
					quantity = 1;
				}else{
					quantity = Integer.parseInt(array3[2]);
					flight = true;
				}
				if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Refreshment" && flight == true){
					subtotal = .95*productList.get(j).calcSub(quantity, distance);
					taxes = productList.get(j).calcTax(quantity, distance);
					finalsub = subtotal + finalsub;
					finaltax = taxes + finaltax;
				}else{
					subtotal = productList.get(j).calcSub(quantity, distance);
					taxes = productList.get(j).calcTax(quantity, distance);
					finalsub = subtotal + finalsub;
					finaltax = taxes + finaltax;
				}
				//System.out.printf("%.2f  %.2f  %.2f \n" ,subtotal,  taxes, taxes+subtotal);


			}
			//System.out.printf("%.2f  %.2f  %.2f\n", finalsub, finaltax, finalsub+finaltax);


			for (int j = 0; j < customerArr.length; j++){
				if(customerArr[j].getCustomerCode().equals(array[1])){
					b =  customerArr[j];
					j = customerArr.length;
				}
			}
			for (int k = 0; k < personArr.length; k++){
				if(personArr[k].getPersonCode().equals(array[2])){
					c =  personArr[k];
					k = personArr.length;
				}
			}


			if (b.getType().equals("Corporate")){
				discount = (finalsub) * .12*(-1);
				fee = 40.0;
			}else if (b.getType().equals("Government")){
				discount = finaltax*(-1);
			}
			Invoice a = new Invoice(array[0], b, c, (Standard) productArr[1], array[3], productList, finalsub, finaltax, fee, discount);
			invoiceArr[i]=a;

			if (array[2].equals("online")){
				a.printSummary(1);
			}else{
				a.printSummary(0);
			}

		}

		return " ";
	}


	private String getTravelSummary() {
		String q;
		StringBuilder sb = new StringBuilder();
		q = sb.append("===============================================================================================================================================\n").append("FLIGHT INFORMATION\n").append("==================================================\n").append("Day, Date         Flight          Class            DepartureCity and Time               ArrivalCity and Time                       Aircraft").toString();
		System.out.println(q);
		Double taxes = 0.0;
		Double subtotal = 0.0;
		Double finalsub = 0.0;
		Double finaltax = 0.0;
		Double discount = 0.0;
		Double fee = 0.0;
		Airport airportArr[] = new Airport[1];
		Person personArr[] = new Person[1];
		Customer customerArr[] = new Customer[1];
		Product productArr[] = new Product[1];
		Scanner s = DataConverter.scanFileIn("data/Invoices.dat");
		Invoice invoiceArr[] = new Invoice[Integer.parseInt(s.nextLine())];
		airportArr = DataConverter.airportToArray();
		personArr = DataConverter.personToArray();
		customerArr = DataConverter.customersToArray(personArr);
		productArr = DataConverter.productsToArray(airportArr);
		for (int i = 0; i < invoiceArr.length; i++){
			int commas = 0;
			subtotal = 0.0;
			taxes = 0.0;
			finalsub = 0.0;
			finaltax = 0.0;
			discount = 0.0;
			fee = 0.0;
			String line = s.nextLine();
			String array[] = line.split(";");
			String array2[] = array[4].split(",");

			List<Product> productList = new ArrayList<Product>();
			Customer b =  customerArr[0];
			Person c = personArr[0];
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == ','){
					commas++;
				}
			}
			boolean flight = false;
			for (int j = 0; j<=commas; j++){
				String array3[] = array2[j].split(":");
				int quantity = 1;
				String distance = null;
				productList.add(DataConverter.findTicket(productArr, array3[0]));
				if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Insurance" || DataConverter.findClass(productArr, array3[0]) == "com.airamerica.CheckedBaggage" || DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Refreshment"){
					quantity = Integer.parseInt(array3[1]);
					if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Insurance"){
						distance = String.valueOf(DataConverter.findTicket(productArr, array3[2]).distance());

					}
				}else if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.SpecialAssistance"){
					quantity = 1;
				}else{
					quantity = Integer.parseInt(array3[2]);
					flight = true;
				}
				if(DataConverter.findClass(productArr, array3[0]) == "com.airamerica.Refreshment" && flight == true){
					subtotal = .95*productList.get(j).calcSub(quantity, distance);
					taxes = productList.get(j).calcTax(quantity, distance);
					finalsub = subtotal + finalsub;
					finaltax = taxes + finaltax;
				}else{
					subtotal = productList.get(j).calcSub(quantity, distance);
					taxes = productList.get(j).calcTax(quantity, distance);
					finalsub = subtotal + finalsub;
					finaltax = taxes + finaltax;
				}
				//System.out.printf("%.2f  %.2f  %.2f \n" ,subtotal,  taxes, taxes+subtotal);


			}
			//System.out.printf("%.2f  %.2f  %.2f\n", finalsub, finaltax, finalsub+finaltax);


			for (int j = 0; j < customerArr.length; j++){
				if(customerArr[j].getCustomerCode().equals(array[1])){
					b =  customerArr[j];
					j = customerArr.length;
				}
			}
			for (int k = 0; k < personArr.length; k++){
				if(personArr[k].getPersonCode().equals(array[2])){
					c =  personArr[k];
					k = personArr.length;
				}
			}


			if (b.getType().equals("Corporate")){
				discount = (finalsub) * .12*(-1);
				fee = 40.0;
			}else if (b.getType().equals("Government")){
				discount = finaltax*(-1);
			}
			Invoice a = new Invoice(array[0], b, c, (Standard) productArr[1], array[3], productList, finalsub, finaltax, fee, discount);
			invoiceArr[i]=a;

			a.flightinformation();

		}

		

		return " ";
	}



	private String getCostSummary() {
		StringBuilder sb = new StringBuilder();
		sb.append("FARES AND SERVICES");
		sb.append("==================================================\n");



		//TODO: Add code for generating Cost Summary of all 
		//products and services in an Invoice

		return sb.toString();

	}

	public String generateDetailReport() {
		StringBuilder sb = new StringBuilder();		
		sb.append("Individual Invoice Detail Reports\n");
		sb.append("==================================================\n");

		/* TODO: Loop through all invoices and call the getTravelSummary() and 
	getCostSummary() for each invoice*/


		return sb.toString();
	}

	public static void main(String args[]) {
		InvoiceReport ir = new InvoiceReport();
		String summary = ir.generateSummaryReport();
		String costsummary = ir.getCostSummary();
		String travelsummary = ir.getTravelSummary();
		System.out.println(summary);
		System.out.println(travelsummary);
		//		System.out.println(costsummary);
	}
}
