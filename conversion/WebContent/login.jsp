<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
<link  href="css/styles.css" rel="stylesheet" type="text/css"/>
<link  href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="validations.js"></script>
</head>
<body >
	<div style="width: 100%; height: 20%; background-color: black; "></div>
		<form action="LoginController" method="get" name="login"   >
		 <div style="width: 100%; height: 50%; background-color: white; ">
		 	<h3>Login page</h3>
		     please provide credentials to for this currency convetor<br/>
		     User Name:<br/>
		     <input type="text" name="email" style="height: 20px;"/><br/>
		     Password:<br/>
		     <input name="password" type="password"  style="height: 20px;" /><br/>
		     new user? <a href="register.jsp" >sign up</a><br/><br/>
		     <a href="resetpassword.jsp">reset password</a><br/><br/>
		     <input type="submit" name="signUp" value="sign in" style="width: 153px; height: 29px" class="btn btn-large btn btn-success" onclick="return formValidation();"/>
		     
		 </div>
		 </form>
		 <div style="width: 100%; height: 20%;background-color: black;" ></div>
</body>
</html>