<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>User Management</title>
</head>
<body>
<form>

<%!
	int max_rid, i;
%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
PreparedStatement ps = con.prepareStatement("SELECT MAX(rid) FROM registration;");
ResultSet rs = ps.executeQuery();
while(rs.next()){
	max_rid = rs.getInt(1);
}
%>
	<table  cellspacing="0">
	<tr>
	<th>Name</th>
	<th>Address</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Status</th>
	<th>Change Status</th>
	</tr>
<%
for(i=2; i<=max_rid; i++){
	PreparedStatement ps1 = con.prepareStatement("SELECT name, address, age, gender, status FROM registration WHERE rid=?");
	ps1.setInt(1, i);
	ResultSet rs1 = ps1.executeQuery();
	while(rs1.next()){
		%>
		<tr>
	<td><%out.println(rs1.getString(1)); %></td>
	<td><%out.println(rs1.getString(2)); %></td>
	<td><%out.println(rs1.getInt(3)); %></td>
	<td><%out.println(rs1.getString(4)); %></td>
	<td><%out.println(rs1.getString(5)); %></td>
	<td>Approve<input type="radio" name="status<%out.println(i); %>" value="approve">Disapprove<input type="radio" name="status<%out.println(i); %>" value="disapprove"></td>
	</tr>
		<%
	}
}
%>
<tr>
<td colspan="6"><input type="submit" name = "radiovalue" value="Submit"></td>
</tr>
</table>
</form>
</body>
</html>