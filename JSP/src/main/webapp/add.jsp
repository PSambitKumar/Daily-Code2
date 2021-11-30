<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page session = "true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="session2.jsp">
	<%!
	String a, b, c;
	int total;
	%>
	<%
	a = request.getParameter("t1");
	int a1 = Integer.parseInt(a);
	b = request.getParameter("t2");
	int b1 = Integer.parseInt(b);
	c = request.getParameter("b1");
	if(c.equals("add")){
		total = a1 + b1;
		out.println(total);
	}
	else{
		total = a1 - b1;
		out.println(total);
	}
	%>
</form>
	
</body>
</html>