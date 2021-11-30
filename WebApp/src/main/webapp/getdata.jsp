<%@ page session="true" import="Project1.getset" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Data</title>
</head>
<body>

<%
//getset gs2 = new getset();
//int r1 = gs2.getResult1();
//int r2 = gs2.getResult2();
//out.println(r1);
//out.println(r2);
Object ob = (String)session.getAttribute("p1");
out.println(ob);

%>
</body>
</html>