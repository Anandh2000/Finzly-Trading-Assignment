package com.finzly.assignment.fxtrading.menu;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.finzly.assignment.fxtrading.data.FxDataManager;
import com.finzly.assignment.fxtrading.options.TradeBooker;
import com.finzly.assignment.fxtrading.options.TradeExit;
import com.finzly.assignment.fxtrading.options.TradePrinter;

public class FxTraderMenu {
	
	//this method displays the menu of the Foreign Exchange trade
	public static void fxTraderMenu(LinkedHashSet<FxDataManager> tradeData) {
		Scanner input = new Scanner(System.in);
		String exit = "y";
		int option;
		while(exit.equals("y")) {
			System.out.println("------------------WELCOME------------------");
			System.out.println();
			System.out.println("MENU");
			System.out.println("1.Book Trade\n2.Print Trade\n3.Exit\nEnter the option");
			try {
				option = input.nextInt();
				//each option is selected through switch case
				switch(option) {
					case 1 :{
						TradeBooker trade = new TradeBooker();
						trade.book(tradeData);                //method in tradebooker is called
						break;
					}
					case 2 :{
						TradePrinter print = new TradePrinter();
						print.printData(tradeData);           //method in tradeprinter is called
						break;
					}
					case 3 :{
						TradeExit exitTrade = new TradeExit();
						exit = exitTrade.tradeExit();         //method in tradeexit is called
						break;
					}
					default:{
						throw new InputMismatchException();
					}
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid option! Please provide correct option");
				fxTraderMenu(tradeData);
			}
			
		}
	}
}
