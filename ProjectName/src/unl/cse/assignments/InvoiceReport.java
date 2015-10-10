package unl.cse.assignments;

import java.util.Scanner;

import com.airamerica.Address;
import com.airamerica.Airport;

/* Assignment 3,5 and 6 (Project Phase-II,IV and V) */

public class InvoiceReport {
	
	private String generateSummaryReport() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Executive Summary Report\n");
		sb.append("=========================\n");
		
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
//	
//	Scanner s = null; 
//	s = DataConverter.scanFileIn("data/Invoices.dat");
//	Airport airportArr[] = new Airport[Integer.parseInt(s.nextLine())];
//	//Loops through all the lines of the airport data file and creates airport objects
//	for (int i = 0; i < airportArr.length; i++){
//		int commas = 0;
//		String line = s.nextLine();
//		String array[] = line.split(";");
//		String array2[] = array[4].split(",");
//		for(int j = 0; j < line.length(); i++) {
//		    if(line.charAt(j) == ',') commas++;
//		}
//		for (int j = 0; j<=commas; j++){
//			String array4[] = array[4+j].split(":");
//		}
//		Airport b = new Airport(array[0], array[1], a, latitudeDeg, latitudeMin, longitudeDeg, longitudeMin, Double.parseDouble(array[4]));
//		airportArr[i] = b;
//	}
	
	return sb.toString();
	}

	public static void main(String args[]) {
		
		InvoiceReport ir = new InvoiceReport();
		String summary = ir.generateSummaryReport();
		String details = ir.generateDetailReport();
				
		System.out.println(summary);
		System.out.println("\n\n");
		System.out.println(details);
		
		System.out.println("======================================================================================================================");
		System.out.println("\n\n");
		
	}
}
