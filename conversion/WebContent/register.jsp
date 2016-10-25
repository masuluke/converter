<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link  href="css/styles.css" rel="stylesheet" type="text/css"/>
<link  href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="validations.js" type="text/javascript"></script>
</head>
<body>
		<div align="center">
			<h3>Registration form</h3>
			please enter required details below....
		</div>
		<form action="RegisterController" method="post" name="register" id="register" >
		<div style="text-align: center;border: dotted; ">
				<table align="center">
					<tr>
						<td>
							ID Number<br/>
							<input type="text" name="idNumber" id="idNumber"/><br/>
							Name<br/>
							<input type="text" name="name" id="name"/><br/><br/><br/>					
						</td>
						<td>
							
							Second Name<br/>
							<input type="text" name="secondName" id="secondName"/><br/>
							Surname<br/>
							<input type="text" name="surName" id="surName"/><br/><br/><br/>
						</td>
						<td>
							Email<br/>
							<input type="text" name="email" id="email"/><br/>
							Password<br/>
							<input type="text" name="password" id="password"/><br/>
							Confirm Password<br/>
							<input type="text" name="cPassword" id="cPassword"/><br/>
						</td>
					</tr>
				</table>
				<input type="submit" name="signup" value="sign up"  class="btn btn-small btn btn-success" onclick="return registerValidation();" />
				<input type="submit" name="clear" value="clear"  class="btn btn-small btn btn-danger " onclick="return clearregisterValidation()"/>
		</div>
		</form>
</body>
</html>