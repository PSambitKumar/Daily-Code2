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
				<td colspan="2"><center>Batch Master</center><br></td>
			</tr>
		</thead>
		<tbody>
			
				<tr>
				<td><center>Add Batch: </center></td>
				<td><a href = "${pageContext.request.contextPath}/AddBatch">Add Batch</a></td>
			</tr>
		</tbody>
		<tfoot>
			
		</tfoot>
	</table>
	
</body>
</html>