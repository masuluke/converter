package com.currency.convetor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.currency.convetor.service.CurrencyService;
import com.currency.convetor.service.LoginService;

import com.currency.convetor.model.Currency;
import com.currency.convetor.model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter writeHtml = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		LoginService loginService = new LoginService();
		CurrencyService currencyService = new CurrencyService();
		User user = loginService.userDetails(email);
		List<Currency> currencies = currencyService.readAllCurrency();
		
		try {
			
			
			
			
			if (!currencies.isEmpty()) 
			{
				request.getSession().setAttribute("currencies", currencies);				
			}
			else
			{
				boolean currTF =currencyService.defaultCurrency();
				if (currTF == true) 
				{
					currencies = currencyService.readAllCurrency();			
					
				}
			}
				
			
			boolean authentication = loginService.authenticateUserDetails(email, password);
			if (authentication == true ) 
			{
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("currencies", currencies);
				response.sendRedirect("conversion_page.jsp");
				
			}
			else
			{
				writeHtml.println("<html>");
				writeHtml.println("<head>");		
				writeHtml.println("<title>Error</title>");		
				writeHtml.println("</head>");
				writeHtml.println("<body>");
				writeHtml.println("<center>");
				writeHtml.println("<h1>Invalid login details:</h1>");
				writeHtml.println("New user? please register<a href=register.jsp>Click here or</a><br/>");
				writeHtml.println("To try again<a href=register.jsp>Click here</a>");
				writeHtml.println("</center>");
				writeHtml.println("</body>");
				writeHtml.println("</html>");
				
			}
				
				
				
			
		}finally {
			
		}
		
	}

	
}
