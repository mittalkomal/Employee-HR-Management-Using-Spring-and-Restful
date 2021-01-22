<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
fieldset {
	 background-color: #33D5FF;
	  padding: 30px 25px;
	   border: 10px groove (internal value);
}

legend {
  background-color: gray;
  color: white;
  padding: 5px 10px;
}


div {
	width: 300px;
	position: fixed;
	top: 30%;
	left: calc(50% - 150px);
}

form input {
	float: right;
	margin-right: 20px;
	border: 0.5px solid black;
}

p {
	margin: 10px 20px 0px 0px;
	font-size: small;
	float: right;
	color: red;
}

span {
	font-size: small;
	color: red;
}

.fixed-header, .fixed-footer {
	width: 100%;
	position: fixed; 
	background: #333;
 	padding: 0 0; 
	color: #fff;
	text-align: center;
}

.fixed-header {
	top: 0;
}

.fixed-footer {
	bottom: 0;
}
</style>
</head>
<body style="background-color:#AFEDFC;">
<h4 class="fixed-header">Employee Management Tool</h4> 
	<div id="login">
	 <header> 
                
            </header> 
		<fieldset>
			<legend>Login</legend>
			<form action="login" method="post">
				<label>UserName : <input name="userId" required></label> <br>
				<br> <label>Password : <input name="pass"
					type="password" required></label> <br> <br> <input type="submit"
					value="Login" id="loginSubmitBtn"  style="margin-left: 50%" >
			</form>
			<p>${InvalidationMsg}</p>
		</fieldset>
	</div>
<h4 class="fixed-footer">Copyright @Nagarro</h4> 
</body>
</html>