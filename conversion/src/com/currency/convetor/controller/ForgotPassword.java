package com.currency.convetor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.currency.convetor.model.User;
import com.currency.convetor.service.UserService;

public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter writeHtml = response.getWriter();
		
		String idNumber = request.getParameter("idNumber");
		String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");      
        
        UserService userService = new UserService();
        User user = userService.getUserById(idNumber);
        
        try 
        {
        	
            
            
            user.setPassword(password);
    		
        
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
