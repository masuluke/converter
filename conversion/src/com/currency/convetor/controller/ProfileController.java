package com.currency.convetor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.currency.convetor.model.User;
import com.currency.convetor.service.UserService;


public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String idNumber = request.getParameter("idNumber");
		String name = request.getParameter("name");
		String secondName= request.getParameter("secondName");
		String surName = request.getParameter("surName");
		String email = request.getParameter("email");
        String password = request.getParameter("password");
		
		User user = new User(Long.parseLong(idNumber), name, secondName, surName, email, password);
		UserService userService = new UserService();

		try 
		{
			boolean results =userService.updateUser(user);
			if (results == true) 
			{
				user = userService.loginDetails(user);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("profile.jsp");
			}
			else
			{
				response.sendRedirect("editprofile.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}


}
