package unl.cse.assignments;

import java.util.Scanner;

import com.airamerica.Address;
import com.airamerica.Airport;
import com.airamerica.Customer;
import com.airamerica.Invoice;
import com.airamerica.Person;
import com.airamerica.Product;

/* Assignment 3,5 and 6 (Project Phase-II,IV and V) */

public class InvoiceReport {

	private String generateSummaryReport() {
		StringBuilder sb = new StringBuilder();

		sb.append("Executive Summary Report\n");
		sb.append("=========================\n");
		sb.append("Invoice                    Customer                           Salesperson            Subtotal     Fees    Taxes     Discount     Total" );


		//TODO: Add code for generating summary of all Invoices

		return sb.toString();
	}


	private String getTravelSummary() {
		StringBuilder sb = new StringBuilder();
		sb.append("FLIGHT INFORMATION");
		sb.append("==================================================\n");

		//TODO: Add code for generating Travel Information of an Invoice

		return sb.toString();

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
		System.out.println(summary);
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
			String line = s.nextLine();
			String array[] = line.split(";");
			String array2[] = array[4].split(",");
			Customer b =  customerArr[0];
			Person c = personArr[0];
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == ','){
					commas++;
				}
			}
			for (int j = 0; j<=commas; j++){
				String array3[] = array2[j].split(":");
			}
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
			Invoice a = new Invoice(array[0], b, c, array[3]);
			invoiceArr[i]=a;

			
			if (array[2].equals("online")){
				a.printSummary(1);
			}else{
				a.printSummary(0);
			}
		}


		//		System.out.println("\n\n");
		//		System.out.println(details);
		//		System.out.println("======================================================================================================================");
		//		System.out.println("\n\n");


	}
}
