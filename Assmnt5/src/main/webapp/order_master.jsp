<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Master</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<center><h3>Order Master</h3></center>
<%!
	int i = 1;
	String id = "OR-2021-000"+i;
%>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
//out.println("Connected");
PreparedStatement ps = con.prepareStatement("SELECT orderid FROM order_master");
ResultSet rs = ps.executeQuery();

%>

<form action="order_process"  method="post">
	<table align="center" border="0" cellspacing="0">
		<tr>
			<th colspan="2">Order Master</th>
		</tr>
		<tr>
			<td>Order ID</td><%
			while(rs.next()){
				String id1 = rs.getString(1);
				//out.println(id1);
				while(id1.equalsIgnoreCase(id)){
					i = i+1;
					id = "OR-2021-000"+i;
				}
			}%>
			<td> <input type="text" name="orderid" value="<%out.println(id); %>"></td>
					</tr>
		
		<tr>
		<td>Date:</td>
		<td><input type="date" name="orderdate"></td>
		</tr>
		
		<tr>
		<td>Customer Name::</td>
		
		<td>
			<select name="name">
		<%
		PreparedStatement ps1 = con.prepareStatement("SELECT Name FROM customer");
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next()){
			String name = rs1.getString(1);
		%> 
			<option value = "<%out.println(name);%>"><%out.println(name);%> </option>    
		<%
		} %>
		</select> 
			</td>
		</tr>
		
		    <tr>
     <td>Order Status:</td>
     <td>Active<input type="radio" id="status" name="status" value="active">
			Inactive<input type="radio" id="status2" name="status" value="inactive">
    </tr>
    
    <tr><td colspan="2"><input type="submit" value="Submit"><input type="reset" value="Reset"></td></tr>
		
	</table>
</form>
</body>
</html>