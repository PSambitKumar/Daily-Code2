<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="function.js"></script>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Registration Page</title>

</head>
<body>

<%!
	int id = 1;
%>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
PreparedStatement ps = con.prepareStatement("SELECT userid FROM user_master");
ResultSet rs = ps.executeQuery();

%>

<br>
<br>
<br>
<br>
	<table>
		<tr>
			<td><div align="center"><h1>Welcome</h1></div>
	<div align="center"><h2> Registration Form.</h2></div>
		<div align="center"><p>Already Have an Account: <a href="Login.jsp"><b>Login Here</b></a></p></div>
		</td>
			<td>
			<form name="myForm" onsubmit="return validateForm()" action="Regd" method="post" enctype="multipart/form-data">
		<table cellpadding="4">
			<tr>
            <td>User ID</td>
            <%
			while(rs.next()){
				int id1 = rs.getInt(1);
				while(id1 == id){
					id = id+1;
					}
				}%>
            <td><label><%=id %></label></td>
        </tr>
        
        <tr>
            <td>Password:</td>
            <td><input type="password" id = "userpass1"name="userpass" placeholder="Enter Password"></td>
        </tr>
        
        <tr>
            <td>User Name:</td>
            <td><input type="text" id = "username1"  name="username" placeholder="Enter Username" ></td>
        </tr>
        
        <tr>
            <td>User Address:</td>
            <td><textarea id = "useradd1" name="useradd" placeholder="Enter Address" rows="3" cols="21"></textarea></td>
        </tr>
        
        <tr>
            <td>User Gender</td>
            <td><input type="radio" id = "usergender" value="Male" name="usergender" checked > Male
                <input type="radio" value="Female" name="usergender"> Female
                <input type="radio" value="Other" name="usergender"> Other</td>
        </tr>
        
        <tr>
            <td>Phone Number:</td>
            <td><input type="number" id="userphn1" name="userphn" placeholder="Phone Number" maxlength="10"></td>
        </tr>
        
        <tr>
            <td>Email Address:</td>
            <td><input type="email" id="useremail" name="useremail" placeholder="Enter Email Address"></td>
        </tr>
        
         <tr>
            <td>Date of Birth:</td>
            <td><input type="date" id = "userdob" name="userdob"></td>
        </tr>
        
        <tr>
            <td><label for="img">Select Image:</label></td>
            <td><input type="file" id="img" name="userphoto" accept="image/*"></td>
        </tr>
        
        <tr>
            <td colspan="2"><input type="reset" Value="Reset"><input type="submit" Value="Submit"></td>
        </tr>
		</table></form></td>
		</tr>
	</table>
	<br><br><br><br>
	</body>
</html>