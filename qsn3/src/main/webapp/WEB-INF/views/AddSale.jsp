<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Allocate Batch</h1>
	
	
	<form:form action="AddSale1" method="post" modelAttribute="addsale">
					<table align="center">
		<tr>
			<td>Select Shop:</td>
			<td>			<select>
				<c:forEach items="${list}" var="e">
					<option value="${e.shopid}">${e.shopname}</option>
				</c:forEach>
			</select></br>
			</td>
		</tr>
		
		<tr>
			<td>Select Product:</td>
			<td>			<select>
				<c:forEach items="${list1}" var="f">
					<option value="${f.productid}">${f.productname}</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		
		<tr>
			<td>Quantity</td>
			<td><form:input path="qty"/></td>
		</tr>
		
		<tr>
			<td>Amount</td>
			<td><form:input path="amount"/></td>
		</tr>
		
		<tr>
			<td><center><button type="submit" >Add Sale</button></center></td>
			<td><center><button type="reset">Reset</button></center></td>
		</tr>
		
	</table>
				
	</form:form>
	
	
	
	
	
	
</body>
</html>