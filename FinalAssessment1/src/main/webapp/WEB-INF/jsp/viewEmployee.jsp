<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2">
		<thead>
			<tr><td>Employee Id</td><td>Employee Name</td></tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp" >
				<tr>
				<td>${emp.empId}</td>
				<td>${emp.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>