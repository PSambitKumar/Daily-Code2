<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import = "java.sql.*,java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!String s1, s2;
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;
%>

<%
try{
	s1 = request.getParameter("t1");
	s2 = request.getParameter("t2");

	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
	ps = con.prepareStatement("SELECT * FROM login WHERE userid=? and password=?");
	ps.setString(1,s1);
	ps.setString(2,s2);
	rs = ps.executeQuery();
	if(rs.next()){
	%>
		<jsp:forward page="success.html"/>
	<%
	}
	else{
	%>
		<jsp:forward page="login.html"/>
	<%
	}
	con.close();
}
catch(Exception e){
}
%>
</body>
</html>