<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is Next Page</title>
</head>
<body>
	<%
		String s1 = request.getParameter("h1");
		out.println("Welcome " + s1);
	%>
</body>
</html>