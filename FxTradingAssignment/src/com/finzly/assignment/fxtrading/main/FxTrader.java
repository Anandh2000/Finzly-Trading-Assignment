package com.finzly.assignment.fxtrading.main;

import java.util.LinkedHashSet;

import com.finzly.assignment.fxtrading.data.FxDataManager;
import com.finzly.assignment.fxtrading.menu.FxTraderMenu;

public class FxTrader {
	
	public static void main(String[] args){
		
		//linkedhashset is used for faster data insertion and retrieval operation with time complexity O(1)
		LinkedHashSet<FxDataManager> tradeData = new LinkedHashSet<>();
		FxTraderMenu.fxTraderMenu(tradeData);
	}
}

