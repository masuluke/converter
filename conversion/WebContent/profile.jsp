<%@page import="com.currency.convetor.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user profile</title>
<% User user =(User) request.getSession().getAttribute("user"); %>
</head>
<body>
		
		 <table style="background-color: gray;color: white;text-shadow: silver;" align="center">
			<tr>
			   <td>
			   		<a href="conversion_page.jsp">conversion screen</a>
			   </td>
			   <td>
			   		<a href="currency_management.jsp">currency list management screen</a>
			   </td>
			</tr>
        </table>
		<div align="center">
			<h1 align="center">User profile</h1><br/>
			<a href="editprofile.jsp" >Edit profile</a>
			
			<table cellspacing="20px" align="center">
				<tr>
					<td>ID Number</td>
					<td><%=user.getIdNumber() %></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><%=user.getName() %></td>
				</tr>
				<tr>
					<td>Second name</td>
					<td><%=user.getSecondName() %></td>
				</tr>
				<tr>					
					<td>Surname</td>
					<td> <%=user.getSurName()%></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><%=user.getEmail()%></td>
				</tr>
			</table>
		</div>
</body>
</html>