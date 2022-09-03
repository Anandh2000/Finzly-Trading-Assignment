package com.finzly.assignment.fxtrading.options;

import java.util.LinkedHashSet;

import com.finzly.assignment.fxtrading.data.FxDataManager;

public class TradePrinter {
	
	//prints the data stored in linkedhashset and the timecomplexity is O(1) 
	public void printData(LinkedHashSet<FxDataManager> tradeData) {
	
		System.out.println("***********************************TRADING DATA*************************************");
		System.out.printf("%s %14s %18s %15s %17s\n","TradeNo","CurrencyPair","CustomerName","Amount","Rate");
		for(FxDataManager fxData : tradeData) {
			System.out.printf("%3s %13s %21s %20s %14s",fxData.getTradeNumber(),fxData.getCurrencyPair(),
					fxData.getCustomerName(),new FxDataManager().formatedAmount(fxData.getAmount()),fxData.getRate());
			System.out.println();
		}
		
		
	}

}
