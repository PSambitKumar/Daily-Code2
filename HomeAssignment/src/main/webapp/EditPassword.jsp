<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Reset Password</title>
</head>
<body>
<%! 
	String data, data1, username, password, imageFileName;
%>
	<%
		int userid = (Integer)session.getAttribute("x3");
		username = (String)session.getAttribute("x4");
		password = (String)session.getAttribute("x5");
		imageFileName = (String)session.getAttribute("x6");
		
		session.setAttribute("b1", userid);
		session.setAttribute("b2", username);
		session.setAttribute("b3", password);
		
		data = (String)request.getAttribute("k1");
		//data1 = (String)request.getAttribute("k2");
	%>

	<form action="EditPassword" method="post"><br><br><br><br>
		<table>
		<tr>
			<td><h3>Edit Password</h3><br>
			<img src="userphotos/<%=imageFileName %>" width="120" height="120" alt="<%=imageFileName%>"><br><a href="Login.jsp"><b>Logout</a></td>
			<td><table><br><br><br><br>
			    
        
         
        
        <tr>
            <td>Current Password:</td>
            <td><input type="text" name="currpass" placeholder="Type here"></td>
        </tr>
        
        <tr>
            <td>New Password:</td>
            <td><input type="text" name="newpass" placeholder="Type here"></td>
        </tr>
        
         <tr>
            <td>New Password:</td>
            <td><input type="text" name="newpass1" placeholder="Type here"></td>
        </tr>
        
        <tr>
        <td colspan="2"><center><input type="submit" name="submit" value="Update"><br></center></td>
        </tr>
        
        <%
        if(data != null){
        	%><tr>
        <td colspan="2"><%=data %></td>
        </tr>	
        	<%
        }
        else{
        	%><tr>
        <td colspan="2">Update and Wait for Status!</td>
        </tr><%
        }
        %>
        
		</table><br><br><br><br></td>
		</tr>
		
		</table>
	</form>
</body>
</html>