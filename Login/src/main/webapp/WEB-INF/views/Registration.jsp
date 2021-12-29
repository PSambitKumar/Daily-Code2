<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration</h1>
	
	<div class="reg">
			<form:form action = "/SaveRegistration" modelAttribute="registration">
				Enter Username: <form:input path="username"/><br/>
				Enter Password: <form:input type="password" path="password"/><br/>
				Enter Name: <form:input path="name"/><br/>
				Enter Phone Number: <form:input type="number" path="phone"/><br/>
				Enter Email: <form:input path="email"/><br/>
				
					Select Department:<form:select path="dept">
							<form:option value="Finance">Finance</form:option>
							<form:option value="BSS">BSS</form:option>
							<form:option value="Delivery">Delivery</form:option>
							<form:option value="HR">HR</form:option>
					</form:select><br/>
				
				Select Gender: <form:radiobutton path="gender" value = "Male"/>Male&nbsp;
					<form:radiobutton path="gender" value = "Female"/>Female&nbsp;<br/>
				Select DOB: <form:input type="date" path="dob"/><br/>	
				
				
				<button type = "submit">Register</button>
				<button type = "reset">Reset</button>
			</form:form>
		
	</div>
</body>
</html>