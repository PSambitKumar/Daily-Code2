<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="MailPassword" method="post"><br><br><br><br>
		<table>
		<tr>
			<td><h3>Change Password</h3><br>
			<td><table><br><br><br><br>
			    
        
        <tr>
            <td>New Password:</td>
            <td><input type="text" name="newpass" placeholder="Enter here"></td>
        </tr>
        
        <tr>
            <td>Retype Password:</td>
            <td><input type="text" name="newpass1" placeholder="Enter here"></td>
        </tr>
        
<%--         <%
        String data =(String)request.getAttribute("d1");
        %> --%>
        
        <tr>
        <td colspan="2"><center><input type="submit"  value="Update Password"><br></center></td>
        </tr>
        
<%--         <%
        if(data != ""){
        	%>
        	<tr>
        <td colspan="2"><%=data %></td>
        </tr>
        	<% --%>
<!--         }
        %> -->
        
		</table><br><br><br><br></td>
		</tr>
		
		</table>
	</form>
</body>
</html>