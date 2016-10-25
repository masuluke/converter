<%@page import="com.currency.convetor.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit profile</title>
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
			    <td>
			   		<a href="profile.jsp">user profile</a>
			   </td>
			</tr>
        </table>
		<div align="center">
			<h1 align="center">User profile</h1>
			<form action="ProfileController" method="get">	
			<table cellspacing="20px" align="center">
				<tr>
					<td>ID Number</td>
					<td><input type="text" name="idNumber" id="idNumber" value="<%=user.getIdNumber()%>"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" id="name" value="<%=user.getName() %>"/></td>
				</tr>
				<tr>
					<td>Second name</td>
					<td><input type="text" name="secondName" id="secondName" value="<%=user.getSecondName() %>"/></td>
				</tr>
				<tr>					
					<td>Surname</td>
					<td><input type="text" name="surName" id="surName" value="<%=user.getSurName()%>"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" id="email" value="<%=user.getEmail()%>"/></td>
				</tr>
			</table>
			<input type="text" name="password" id="password" value="<%=user.getPassword()%> " style="visibility: hidden;"/>
			<input type="submit" name="update" value="update"  class="btn btn-small btn btn-success" onclick="return updateValidation();" />
			</form>	
		</div>
</body>
</html>