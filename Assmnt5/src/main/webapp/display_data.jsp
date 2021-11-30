<%@ page session="true" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Display Data</title>
</head>
<body>
<%!
int rate1, quantity1;
int max_rid;
%>
	<%
	
	String orderid =(String)session.getAttribute("x1");
	String name = request.getParameter("name");
	String rate = request.getParameter("rate");
	int rate1 = Integer.parseInt(rate);
	String quantity = request.getParameter("quantity");
	int quantity1 = Integer.parseInt(quantity);
	
	try {		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
		
		PreparedStatement ps1 = con1.prepareStatement("INSERT INTO order_details(orederid, productname, productrate, productqty)  VALUES(?,?,?,?)");
		ps1.setString(1, orderid);
		ps1.setString(2, name);
		ps1.setInt(3, rate1);
		ps1.setInt(4, quantity1);
		ps1.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
	PreparedStatement ps = con2.prepareStatement("SELECT MAX(slno) FROM order_details;");
	ResultSet rs2 = ps.executeQuery();
	while(rs2.next()){
		max_rid = rs2.getInt(1);
	}
	
	%>
	<form action="order_master.jsp">
	<table  cellspacing="0">
	<tr>
	<th>Sl No</th>
	<th>Product Name</th>
	<th>Product Rate</th>
	<th>Product Quantity</th>
	<th>Total</th>
	</tr>
<%

Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
for(int i=2; i<=max_rid; i++){
	
	PreparedStatement ps4 = con4.prepareStatement("SELECT slno, productname, productrate, productqty  FROM order_details where slno=?");
	ps4.setInt(1, i);
	ResultSet rs4 = ps4.executeQuery();
	while(rs4.next()){
		int x = rs4.getInt(3);
		int y = rs4.getInt(4);
		%>
		<tr>
	<td><%out.println(rs4.getInt(1)); %></td>
	<td><%out.println(rs4.getString(2)); %></td>
	<td><%out.println(x); %></td>
	<td><%out.println(y); %></td>
	<td><%out.println(x*y); %></td>
	</tr>
		<%
	}
}
%>
<tr>
<td colspan="5"><input type="submit" value="Go To Order Master"></td>
</tr>
</table>
	</form>
</body>
</html>