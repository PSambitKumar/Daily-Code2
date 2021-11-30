<%@ page session="true" import="java.sql.*" import="java.text.SimpleDateFormat" import ="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h3>Order Detail</h3></center>
	<%
	String orderid = request.getParameter("orderid");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
	//out.println("connected");
	PreparedStatement ps = con.prepareStatement("SELECT name FROM product");
	ResultSet rs = ps.executeQuery();
	session.setAttribute("x1",orderid);
	%>
	
<form action="display_data.jsp" method="post">

	<table align="center" cellspacing="0">
		<tr>
			<th colspan="2">Order Detail</th>
		</tr>
		
		<tr>
			<td>Order ID:</td>
			<td><label><%out.println(orderid); %></label></td>
		</tr>
		
				<tr>
			<td>Product Name:</td>
			<td>
			<select name="name"><%
			while(rs.next()){
				String name = rs.getString(1);
				%>
				<option value = "<%out.println(name);%>"><%out.println(name);%> </option><%
			} %>
			</select> 
			</td>
		</tr>
		
		<tr>
			<td>Product Rate:</td>
			<td><input type="text" name="rate"></td>
		</tr>
		
		<tr>
			<td>Quantity:</td>
			<td><input type="text" name="quantity"></td>
		</tr>
		
		<tr><td colspan="2"><input type="submit" value="Submit"></td></tr>

</form>
		
	</table>
</body>
</html>