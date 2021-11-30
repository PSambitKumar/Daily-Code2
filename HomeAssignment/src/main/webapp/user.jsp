<%@ page session="true" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%!
int userid;
String imageFileName;
%>
<%
String username = (String)session.getAttribute("x1");
String password = (String)session.getAttribute("x2");



Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
String sql = "SELECT userid, userphoto FROM user_master WHERE username=? AND userpass=?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, username);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
while(rs.next()){
	userid = rs.getInt(1);
	imageFileName = rs.getString(2);
	//out.println(imageFileName);
}

session.setAttribute("x3",userid);
session.setAttribute("x4",username);
session.setAttribute("x5",password);
session.setAttribute("x6",imageFileName);

%>

<form action="">
	<table><br><br><br><br><br>
		<tr>
			<td><a href="EditPassword.jsp">Edit Password</a></td>
			<td><a href="EditProfile.jsp">Edit Profile</a></td>
			<td><a href="Login.jsp">Logout</a></td>
		</tr>
		
		<tr>
			<td colspan="2"><h3>Welcome <%out.println(username);%></h3></td>
			<td><br><br><br><img src="userphotos/<%=imageFileName %>" width="150" height="150" alt="<%=imageFileName%>"><br><br><br></td>
		</tr>
	</table>
</form>
</body>
</html>