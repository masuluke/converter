package com.currency.convetor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.currency.convetor.model.Currency;
import com.currency.convetor.service.CurrencyService;


public class CurrencyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CurrencyListController() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CurrencyService currencyService = new CurrencyService();
		List<Currency> currencies = currencyService.readAllCurrency();
		try 
		{
			
			
			if (!currencies.isEmpty()) 
			{
				request.getSession().setAttribute("currencies", currencies);
				response.sendRedirect("currency_management.jsp");
			}
			else 
			{
				
				boolean  result = currencyService.defaultCurrency();
				if (result == true  ) 
				{
					currencies = currencyService.readAllCurrency();			
					request.getSession().setAttribute("currencies", currencies);
					response.sendRedirect("currency_management.jsp");
				}
				else {
					response.sendRedirect("conversion_page.jsp");
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}



}
