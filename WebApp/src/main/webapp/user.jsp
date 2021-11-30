<%@ page import="java.util.*, java.sql.*" import="Project1.JDBCConnection"  session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>User Page</title>
</head>
<body>
<form action="Login.jsp" method="post">
<%
	String sql = "call getData(?)";
	Vector v = (Vector)session.getAttribute("vpass");
	Object ob = v.elementAt(0);
	Object ob1 = v.elementAt(1);
	int reid = (Integer)ob;
	String username = (String)ob1;
	%>
	<p>Welcome <%out.println(username); %></p>
	<% 
	//out.println(ob);
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, reid);
	ResultSet rs = ps.executeQuery();
	%>
	<table cellspacing="0">
	<%
	while(rs.next()){
		%>
			<tr>
				<th>Name:</th>
				<td><%out.println(rs.getString(1)); %></td>
				<td><button name="changename">Update</button></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><%out.println(rs.getString(2)); %></td>
				<td><button name="changeaddress">Update</button></td>
			</tr>
			<tr>
				<th>Age:</th>
				<td><%out.println(rs.getInt(3)); %></td>
				<td><button name="changeage">Update</button></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td><%out.println(rs.getString(4)); %></td>
				<td><button name="changegenser">Update</button></td>
			</tr>
		<%
	}
%>
	<tr>
				<td colspan="2"><button name="deleteacc">Delete Account</button></td>
				<td><input type="submit" name="close" value="Close"></td>
			</tr>
	</table>
	</form>
</body>
</html>