<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reset</title>
</head>
<body style="text-align: center;">
		<h1>Reset you password</h1>
		forget password?
		<form action="ForgotPassword" method="get">
		<table cellspacing="20px" align="center">
				<tr>
					<td>ID Number</td>
					<td><input type="text" name="idNumber" id="idNumber" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" id="password"/></td>
				</tr>
				<tr>
					<td>comfirm passowd</td>
					<td><input type="text" name="cpassword" id="cpassword" /></td>
				</tr>
		</table>
		<input type="submit" name="reset" value="reset password"  class="btn btn-small btn btn-success" onclick="formValidation();" />
		</form>
</body>
</html>