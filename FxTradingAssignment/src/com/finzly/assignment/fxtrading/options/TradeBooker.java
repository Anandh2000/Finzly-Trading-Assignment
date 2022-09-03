package com.finzly.assignment.fxtrading.options;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.finzly.assignment.fxtrading.data.FxDataManager;

public class TradeBooker {
	private static int tradeNumber = 0;
	private String customerName;
	private String currencyPair;
	private double amount;
	private double rate = 66.00;
	private String displayRate;
	private String BookOrCancel;
	Scanner sc = new Scanner(System.in);
	
	//this method get details from the user
	public void book(LinkedHashSet<FxDataManager> tradeData) {
		System.out.println("Enter the Customer Name:");
		customerName = nameValidater();
		System.out.println("Enter the CurrencyPair");
		currencyPair = currencyPairValidator();
		System.out.println("Enter the amount to transfer");
		amount = amountCalculator();
		System.out.println("Do you want to get rate(yes/no):");
		displayRate();
		System.out.println("Book/Cancel this trade? type(Book/Cancel)");
		BookingValidator(tradeData);
		
	}

	//method to book or cancel the trade
	private void BookingValidator(LinkedHashSet<FxDataManager> tradeData) {
		BookOrCancel = sc.next();
		if(BookOrCancel.equalsIgnoreCase("Book")) {         //datas will get added in linkedhashset 
			tradeData.add(new FxDataManager(tradeNumber+1, currencyPair, customerName, amount, rate));
			System.out.println("Trade for "+ currencyPair +"has been booked with "+String.format("%.2f", rate) +", The amount of Rs "+ 
			new FxDataManager().formatedAmount(amount)+ " will be transferred in 2 working days to "+ customerName);
		}
		else if(BookOrCancel.equalsIgnoreCase("Cancel")) {
			System.out.println("Trade is Cancelled");
		}
		else {
			System.out.println("Please enter valid option !");
			BookingValidator(tradeData);
		}
		
	}

	//displays the data of how much amount is transfered and customer name
	private void displayRate(){
		displayRate = sc.next();
		if(displayRate.equalsIgnoreCase("yes")) {
			System.out.println("You are transferring INR "+ amount+" to "+customerName);
		}	
	}
	
	//calculates the amount
	private double amountCalculator(){
		try {
		amount = sc.nextDouble();
		if(amount<=0) {
			throw new InputMismatchException();
		}
		else {
			return amount*rate;
		}
		}
		catch(Exception e){ 
			System.out.println("Enter the correct value of amount ");
			return new TradeBooker().amountCalculator();
		}
	}
	
	//currency pair checker
	private String currencyPairValidator() {
		currencyPair = sc.nextLine();
		if(currencyPair.equalsIgnoreCase("USDINR")) {
			return currencyPair.toUpperCase();
		}
		else {
			System.out.println("Only USDINR is valid Please enter again ");
			return currencyPairValidator();
		}
		
	}

	//Checks the format of user name
	private String nameValidater() {
		customerName = sc.nextLine();
		boolean nameChecker = customerName.matches("[a-zA-Z\\s+]+[.]+");
		if(nameChecker == true) {
			return customerName;
		}
		else {
			System.out.print("Enter the name correct format like (Jhon H.) ");
			return nameValidater();
		}
	}

}
