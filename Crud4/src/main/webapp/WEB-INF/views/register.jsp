<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
</head>
<body>
	
	<table align="center">
		<thead>
			<tr>
				<td colspan="2"><center>Registrtion Here</center></td>
			</tr>
		</thead>
		<tbody>
			<form:form action="Register" method="post" modelAttribute="empBean">
				<tr>
					<td>Branch Desc.:</td>
					<td><form:input path="BatchDesc"/></td>
				</tr>
				
				<tr>
					<td>Start Time.:</td>
					<td><form:input path="StartTime"/></td>
				</tr>
				
				<tr>
					<td>End Time.:</td>
					<td><form:input path="EndTime"/></td>
				</tr>
				
				<tr>
					<td>Start Date.:</td>
					<td><form:input path="StartDate"/></td>
				</tr>
				
				<tr>
					<td>End Date.:</td>
					<td><form:input path="EndDate"/></td>
				</tr>
				
				<tr>
					<td><center><button >Register</button></center></td>
					<td><center><button type="reset">Reset</button></center></td>
				</tr>
			</form:form>
		</tbody>
		<tfoot>
			<tr>
				<td>Already a User: </td>
				<td>&emsp;&emsp;<a href = "${pageContext.request.contextPath}/Login">Login</a></td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>