package com.currency.convetor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.currency.convetor.model.Currency;

import com.currency.convetor.service.CurrencyService;


public class CurrencyCalculations extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CurrencyCalculations() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currencyName = request.getParameter("currencyName");
		String currencyNameF = request.getParameter("currencyNameF");
		String currencyValue = request.getParameter("currencyValue");
		
		CurrencyService currencyService = new CurrencyService();
		Currency currencyT = currencyService.readCurrency(currencyName);
		Currency currencyf = currencyService.readCurrency(currencyNameF);
		String finalAnswer = "";
		try 
		{
			
			   if (currencyT.getCurrencyName().contains("US dollar")) 
			   {
				    double rate =  currencyT.getConversion_rate();
				    String xrate = ""+rate;
					finalAnswer = ""+Double.parseDouble(currencyValue)*rate;
					request.getSession().setAttribute("finalAnswer",finalAnswer );
					request.getSession().setAttribute("xrate",xrate);
					request.getSession().setAttribute("currencyName",currencyName);
					request.getSession().setAttribute("currencyNameF",currencyNameF);
					response.sendRedirect("conversion_page.jsp");
			   }
			   else
			   {
				    double rate =  currencyT.getConversion_rate();
				    String xrate = ""+rate;
				    finalAnswer = ""+Double.parseDouble(currencyValue)*rate;
				    request.getSession().setAttribute("finalAnswer",finalAnswer );
				    request.getSession().setAttribute("xrate",xrate);
				    request.getSession().setAttribute("currencyName",currencyName);
					request.getSession().setAttribute("currencyNameF",currencyNameF);
				    response.sendRedirect("conversion_page.jsp");
			   }
				
			
		} 
		catch (Exception e) {
			
		}
		
		/*double xrate =  toCurrency.getConversion_rate();
		
		double convertedCurr = Double.parseDouble(currencyValue)*xrate;
		
		System.out.println("convertedCurr"+convertedCurr);*/
		
		
			
			
	}

}
