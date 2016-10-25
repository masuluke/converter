package com.currency.convetor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.currency.convetor.model.User;
import com.currency.convetor.service.UserService;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter writeHtml = response.getWriter();
		
		String idNumber = request.getParameter("idNumber");
		String name = request.getParameter("name");
		String secondName= request.getParameter("secondName");
		String surName = request.getParameter("surName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		 User user = new User(Long.parseLong(idNumber), name, secondName, surName, email, password);
		 UserService userService = new UserService();
		 try {	
		
			 boolean result = userService.register(user);	
			 writeHtml.println("<html>");
			 writeHtml.println("<head>");		
			 writeHtml.println("<title>Registration Successful</title>");		
			 writeHtml.println("</head>");
			 writeHtml.println("<body>");
			 writeHtml.println("<center>");
			 if(result){
				 writeHtml.println("<h1>Thanks for Registering with us :</h1>");
				 writeHtml.println("To login with new UserName and Password<a href=login.jsp>Click here</a>");
			 }else{
				 writeHtml.println("<h1>Registration Failed</h1>");
				 writeHtml.println("To try again<a href=register.jsp>Click here</a>");
			 }
			 writeHtml.println("</center>");
			 writeHtml.println("</body>");
			 writeHtml.println("</html>");
		 } finally {		
			 
		 }
	}

}
