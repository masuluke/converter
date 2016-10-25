<%@page import="com.currency.convetor.model.Currency"%>
<%@page import="java.util.List"%>
<%@page import="com.currency.convetor.model.User"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>currency conversion page</title>
</head>
<body>
<div align="center">
<table style="background-color: gray;color: white;text-shadow: silver;">
	<tr>
	   <td>
	   		<a href="currency_management.jsp">currency list management screen</a>
	   </td>
	   <td>
	   		<a href="profile.jsp">user profile</a>
	   </td>
	</tr>
</table>
<h1>CURRENCY CONVERSION SCREEN</h1>
<%
	User user = (User)session.getAttribute("user");
	String finalAnswer =(String) session.getAttribute("finalAnswer");
	String currencyF =(String) session.getAttribute("currencyNameF");
	String currencyT =(String) session.getAttribute("currencyName");
	String xrate =(String) session.getAttribute("xrate");
	List<Currency> list = (List<Currency>)session.getAttribute("currencies");
	if(finalAnswer == null && currencyF== null && currencyT== null)
	{
		finalAnswer ="0.00";
		currencyF = "Us dollar";
		currencyT = "Rand";
	}

 %>
Welcome <%=user.getName()+" "+user.getSurName() %>
<%=new Date() %><br/>
</div>
<div align="center">
		Compare different currencies to a USA dollar<br/>
		<form action="CurrencyCalculations" method="get" name="currency">
		<div>
			from<%=currencyF %> To <%=currencyT %><br/>
			<label>Amount</label>
			<label  style="height: 200px; width: 282px;">
					
					<%=finalAnswer %> 
			</label>
			<label>rate</label>
			<label  style="height: 200px; width: 282px;">
					
					<%=xrate %> 
			</label>
		</div><br/>
		<label>From</label>
		<select name="currencyNameF">
		<%		 
			 for (Currency c : list) {
		 %>
		 <option value="<%=c.getCurrencyName()%>"><%=c.getCurrencyName()%></option>
		 <%} %>
		</select>
		
		<label>To</label>
		<select name="currencyName">
		 <%		 
			 
			 for (Currency c : list) {
			
		 %>
		 <option value="<%=c.getCurrencyName()%>"><%=c.getCurrencyName()%></option>
		 <%} %>
		</select><br/><br/>
		<input name="currencyValue" type="text" value="" id="currencyValue" style="width: 282px;"/><br/><br/>
		
			<input name="convert" type="submit" value="convert" onclick="return currencyValidation();"/>
			
		</form>
		<input name="clear" type="submit" value="clear" onclick="surname_validation(surName)"/><br/>
		<a href="currency_management.jsp">currency list management screen</a>
		
</div>

</body>
</html>