<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<form action="ForgotPassword" method="post"><br><br><br><br>
		<table>
		<tr>
			<td><h3>Forgot Password</h3><br>
			<td><table><br><br><br><br>
			    
        
        <tr>
            <td>User ID:</td>
            <td><input type="text" name="userid" placeholder="Enter here"></td>
        </tr>
        
        <tr>
            <td>Email Address:</td>
            <td><input type="email" name="useremail" placeholder="Enter here"></td>
        </tr>
        
        <%
        String data =(String)request.getAttribute("d1");
        %>
        
        <tr>
        <td colspan="2"><center><input type="submit" name="submit" value="Send Mail"><br></center></td>
        </tr>
        
        <%
        if(data != null){
        	%>
        	<tr>
        <td colspan="2"><%=data %></td>
        </tr>
        	<%
        }
        %>
        
		</table><br><br><br><br></td>
		</tr>
		
		</table>
	</form>

</body>
</html>