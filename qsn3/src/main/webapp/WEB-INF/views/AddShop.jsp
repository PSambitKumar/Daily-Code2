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
				<td colspan="2"><center><b>ADD SHOP</b></center></td>
			</tr>
		</thead>
		<tbody>
			<form:form action="AddShop1"  modelAttribute="addshop">
				<tr>
					<td>Shop Name:</td>
					<td><form:input path="shopname"/></td>
				</tr>
				
				
				<tr>
					<td><center><button type="submit" >Add Shop</button></center></td>
					<td><center><button type="reset">Reset</button></center></td>
				</tr>
			</form:form>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2"><br><br><center>@Copyright Home.</center></td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>