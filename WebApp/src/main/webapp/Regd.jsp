<%@ page session="true" import="Project1.getset" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
<%!
int x=0;
String s1 = null;
%>
<center>
<h3>Registration Page</h3>

<form action="Regd">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" placeholder="enter you name"></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" placeholder="username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" placeholder="password"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" placeholder="address"></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="text" name="age" placeholder="age"></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><input type="radio" value="Male" name="gender" checked > Male
                <input type="radio" value="Female" name="gender"> Female
                <input type="radio" value="Other" name="gender"> Other</td>
        </tr>
        <tr>
            <td colspan="2"><center><input type="submit" name="b1" value="Register Here"></center></td>
        </tr>
    </table>

    Already Have an Account:<a href="Login.jsp">Login Here</a><br><br>

<%-- <%
	s1 = (String)session.getAttribute("p1");
	x = Integer.parseInt(s1);
	if(x == 1){
		%>
		<label>Registration Successful</label>
		<%
	}
	else if(x == 0){
		%>
		<label></label>
		<%
	}
   %> --%>

</form>
</center>
</body>
</html>
