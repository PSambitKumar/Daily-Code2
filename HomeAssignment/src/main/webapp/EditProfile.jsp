<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%! 
	String data, data1, username, password, imageFileName;
	String s = "Update and Wait For Status";
%>
	<%
		int userid = (Integer)session.getAttribute("x3");
		username = (String)session.getAttribute("x4");
		password = (String)session.getAttribute("x5");
		imageFileName = (String)session.getAttribute("x6");
		
		session.setAttribute("a1", userid);
		session.setAttribute("a2", username);
		session.setAttribute("a3", password);
		
		data = (String)request.getAttribute("s1");
		data1 = (String)request.getAttribute("s2");
		
	%>

	<form action="EditProfile" method="post"><br><br><br><br>
		<table>
		<tr>
			<td><h3>Edit Profile</h3><br>
			<img src="userphotos/<%=imageFileName %>" width="120" height="120" alt="<%=imageFileName%>"></td>
			<td><table><br><br><br><br>
			    <tr>
            <td>User Address:</td>
            <td><textarea name="useradd" placeholder="Enter Address" rows="3" cols="21"></textarea></td>
        </tr>
        
         <tr>
            <td>User Gender</td>
            <td><input type="radio" value="Male" name="usergender" checked > Male
                <input type="radio" value="Female" name="usergender"> Female
                <input type="radio" value="Other" name="usergender"> Other</td>
        </tr>
        
        <tr>
            <td>Phone Number:</td>
            <td><input type="number" name="userphn" placeholder="Phone Number" maxlength="10"></td>
        </tr>
        
        <tr>
            <td>Email Address:</td>
            <td><input type="email" name="useremail" placeholder="Enter Email Address"></td>
        </tr>
        
         <tr>
            <td>Date of Birth:</td>
            <td><input type="date" name="userdob"></td>
        </tr>
        
        <tr>
        <td colspan="2"><center><input type="submit" name="submit" value="Update"><br></center></td>
        </tr>
        
        <%
        if(data != null){
        	%><tr>
        <td colspan="2"><%=data  %></td>
        </tr>	
        	<%
        }
        else if(data == null){
        	%><tr>
            <td colspan="2"><%=s  %></td>
            </tr><%
        }
        else{
        	%><tr>
        <td colspan="2"><%=data1 %></td>
        </tr><%
        }
        %>
        
<!--         <tr>
            <td><label for="img">Select Image:</label></td>
            <td><input type="file" id="img" name="userphoto" accept="image/*"></td>
        </tr> -->
		</table><br><br><br><br></td>
		</tr>
		</table>
	</form>
</body>
</html>