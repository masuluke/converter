<%@page import="com.currency.convetor.model.Currency"%>
<%@page import="java.util.List"%>
<%@page import="com.currency.convetor.service.CurrencyService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>currency list management screen</title>
</head>
<body>
	    <table style="background-color: gray;color: white;text-shadow: silver;" align="center">
			<tr>
			   <td>
			   		<a href="conversion_page.jsp">conversion screen</a>
			   </td>
			   <td>
			   		<a href="profile.jsp">user profile</a>
			   </td>
			</tr>
        </table>
		<form action="CurrencyController" method="get">
		<div align="center">
			<h1>Currency list management screen</h1>
			<div>
				<label>currency</label><br/>
				<input name="currencyName" type="text" id="currencyName"/><br/>
				<label>currency code</label><br/>
				<input name="country_code" type="text" id="country_code"/><br/>
				<label>currency rate</label><br/>
				
			    <input name="conversion_rate" type="text" id="conversion_rate"/><br/><br/>
			    <input name="add" type="submit" id="add" value="add"/>
			    <input name="reset" type="submit" id="reset" value="reset"/>
			</div>			
		</div>
		<br/>
		
		
		<div align="center">
			<table style="border: 2px; border-bottom-color: black; " cellspacing="1px">
				<thead>
					
				</thead>
				 <tbody>
				 <tr>
				 	<td>Currency</td>
					<td>Currency code</td>
					<td>Currency rate</td>
				 </tr>
				 <%
					
					 List<Currency> list = (List<Currency>)session.getAttribute("currencies");
					 for (Currency c : list) {
				 %>
				 <tr>
				 	
					 <td><%=c.getCurrencyName()%></td>
					 <td><%=c.getCountry_code()%>"</td>
					 <td><%=c.getConversion_rate()%></td>
					
				 </tr>
				 
				 <%}%>
				  <%session.setAttribute("list", list); %>	
			 <tbody>
				
			</table>
		</div>
		</form>
</body>
</html>