package com.currency.convetor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.currency.convetor.model.Currency;
import com.currency.convetor.service.CurrencyService;

public class CurrencyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currencyName = request.getParameter("currencyName");
		String country_code = request.getParameter("country_code");
		String conversion_rate = request.getParameter("conversion_rate");
		
		CurrencyService currencyService = new CurrencyService();
		List<Currency> currencies = currencyService.readAllCurrency();
		
		
		boolean result= true;
		try {
			
			
			Currency currency = new Currency( country_code,currencyName,Double.parseDouble(conversion_rate));		
			result = currencyService.addorUpdateCurrency(currency);
			if (result ==true) 
			{
				currencies = currencyService.readAllCurrency();
				request.getSession().setAttribute("currencies", currencies);
				response.sendRedirect("currency_management.jsp");
			}
			else
			{
				response.sendRedirect("currency_management.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

	

}
