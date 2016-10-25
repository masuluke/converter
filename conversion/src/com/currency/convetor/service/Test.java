package com.currency.convetor.service;

import java.util.List;

import com.currency.convetor.model.Currency;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrencyService currencyService = new CurrencyService();
		Currency currency = currencyService.readCurrency("Rand");
		try 
		{
			
			if (currency == null) 
			{
				
					System.out.println("did not");
				
			}
			else
			{
				System.out.println("currency"+currency.getConversion_rate());
			}
			
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
