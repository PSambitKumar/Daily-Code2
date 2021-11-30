<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.CallableStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.function.Predicate" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@page import = "java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Process</title>
</head>
<body>

    <%!
    	String name, address, a, gender, username, password;
    	int age;
        Connection con;
        PreparedStatement ps;
        PreparedStatement ps1;
    %>

    <%
    try{
		    username = request.getParameter("username");
		    password = request.getParameter("password");
		    name = request.getParameter("name");
		    address = request.getParameter("address");
		    a = request.getParameter("age");
		    age = Integer.parseInt(a);
		    gender = request.getParameter("gender");

		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
		    
 		    ps = con.prepareStatement("INSERT INTO registration(name, address, age, gender) VALUES(?,?,?,?)");
		    ps.setString(1,name);
		    ps.setString(2,address);
		    ps.setInt(3,age);
		    ps.setString(4,gender);
		    ps.executeUpdate(); 
		    
		    ps1 = con.prepareStatement("INSERT INTO login(username, password) VALUES(?,?)");
		    ps1.setString(1,username);
		    ps1.setString(2,password);
		    ps1.executeUpdate();
		    
		
		    out.println("Success");
}
catch (Exception e){
    		out.println(e);
}
    %>
</body>
</html>
