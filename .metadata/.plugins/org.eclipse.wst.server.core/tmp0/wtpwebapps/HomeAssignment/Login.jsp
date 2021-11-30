
<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<br>
<br>
<br>
<br>
	<table>
		<tr>
			<td> <form action="Login" method="post">
            <table><br><br><br><br><br><br>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" placeholder="username"><br></td>
                </tr><br>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="password"><br></td>
                </tr>
                <tr>
                    <td colspan="2"><center><input type="submit" name="b1" value="Login Here"><br></center></td>
                </tr>
                <tr>
                    <td colspan="2"><center>Forgot Password.<a href="ForgotPassword.jsp">Click Here</a></center></td>
                </tr>
            </table><br><br><br><br><br><br>
        </form></td>
        
        <td><div align="center"><h1>Welcome</h1></div>
		<div align="center"><h2> Login Form.</h2></div>
		<div align="center"><p>Don't Have an Account: <a href="Regd.jsp"><b>Register Here</b></a></p></div>
		</td>
		</tr><br><br><br><br>
		
	</table>
	<br><br><br><br>
</body>
</html>
