package com.finzly.assignment.fxtrading.options;

import java.util.Scanner;

public class TradeExit {
	Scanner input = new Scanner(System.in);
	//Will exit if we press y
	public String tradeExit() {
		System.out.println("Do you want to really exit(y/n):");
		String exitOption = input.next();
		if(exitOption.equalsIgnoreCase("y")) {
			System.out.println("Bye - Have a good day");
			return "n";
		}
		else if(exitOption.equalsIgnoreCase("n")) {
			return "y";
		}
		else {
			System.out.println("Invalid option! try again");
			return tradeExit();
			
		}
	}

}
