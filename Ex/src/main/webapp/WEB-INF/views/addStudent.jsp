<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action = "/SaveStudent" modelAttribute="addstudent">
		Enter Name: <form:input path="name"/><br/>
		Enter Dept: <form:input path="dept"/><br/>
		
		
		<button type = "submit">Save</button>
	</form:form>

</body>
</html>