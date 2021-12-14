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
	<h1 align="center">List of Category</h1>
	<table border = "1" align="center" cellspacing = "0">
		<tr>
			<th>Category ID</th>
			<th>Category Name</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.catid}</td>
				<td>${e.catname}</td>
				
				<td>
					<a href = "/EditCategory/${e.catid}">Edit</a>
					|
					<a href = "/DeleteCategory/${e.catid}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
		<td colspan="5"><center><button onclick="window.location.href='/AddCategory1'">Add Category</button></center></td>
		</tr>
	</table>
</body>
</html>