<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Employee</h1>
	<form:form  action = "${pageContext.request.contextPath}/save" modelAttribute="addbatch">
		Branch Desc: <form:input path="BatchDesc"/><br/>
		Start Time: <form:input path="StartTime"/><br/>
		End Time: <form:input path="EndTime"/><br/>
		End Time: <form:input path="StartDate"/><br/>
		End Time: <form:input path="EndDate"/><br/>\
		
		
	
		<button type = "submit">Save</button>
	</form:form>
</body>
</html>