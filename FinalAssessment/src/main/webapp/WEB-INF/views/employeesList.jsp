<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" rel="stylesheet">
 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"> </script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"> </script>  
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">   
  <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>  
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" > 
   
   
	<style type="text/css">
body {  
 margin-left: 150px;
 margin-right: 150px;
} 
	</style>
	<script>
	$(document).ready(function() {
	    $('#mytable').DataTable();
	} );
  </script>
  

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">List of Employees</h1>
	<table id="mytable" class="table table-striped table-bordered" border = "0" style="width: 100%" align="center">
		<thead>
			<tr>
			<th>Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Date of Birth</th>
			<th>Actions</th>
		</tr>
		</thead>
		
		
		<tbody>
			<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.name}</td>
				<td>${e.gender}</td>
				<td>${e.department}</td>
				<td>${e.dob}</td>
				<td>
					<a href = "${pageContext.request.contextPath}/employee/${e.id}"><button class="edit-button1">Edit</button></a>
				
					<a href = "${pageContext.request.contextPath}/delete/${e.id}"><button class="delete-button1">Delete</button></a>
				</td>
			</tr>
			
		</c:forEach>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="5"><center><button class="cbutton btn-7" onclick="window.location.href='${pageContext.request.contextPath}/openEmployeeView'">Add Employee</button></center></td>
				
			</tr>			
		</tfoot>
		
	
		
	</table>
	
</body>
</html>