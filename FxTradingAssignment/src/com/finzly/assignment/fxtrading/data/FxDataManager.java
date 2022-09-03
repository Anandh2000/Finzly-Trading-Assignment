package com.finzly.assignment.fxtrading.data;

import java.text.NumberFormat;
import java.util.Locale;

public class FxDataManager {
	private int tradeNumber;
	private String currencyPair;
	private String customerName;
	private double amount;
	private double rate;
	
	//empty Constructor
	public FxDataManager() { }
	
	//Constructor to assign values
	public FxDataManager(int tradeNumber, String currencyPair, String customerName, double amount, double rate) {
		super();
		this.tradeNumber = tradeNumber;
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.rate = rate;
	}
	
	//getters and setters
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	//this method format the number to add commas and Indian Ruppee sybmol at begining 
	public String formatedAmount(double amount) {
		 NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		 return formatter.format(amount);
		
	}
		
}
