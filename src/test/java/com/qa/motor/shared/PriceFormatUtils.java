package com.qa.motor.shared;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class PriceFormatUtils {

	public static double parsePrice(String priceString) {
		try {
			DecimalFormat df = new DecimalFormat();
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setDecimalSeparator('.');
			symbols.setGroupingSeparator(',');
			df.setDecimalFormatSymbols(symbols);
			return df.parse(priceString).doubleValue();
		} catch(ParseException ex) {
			return 0;
		}
	}
	
	public static int parseQuantity(String quantity) {
		if(quantity == null || quantity.isEmpty()) return 0;
		return Integer.parseInt(quantity);
	}
}
