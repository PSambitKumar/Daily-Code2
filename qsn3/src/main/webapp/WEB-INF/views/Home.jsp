<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<table border="0" align="center">
		<thead>
			<tr>
				<td colspan="3"><center><b>WELCOME HOME</b></center></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Shop Master:</td>
				<td><a href = "${pageContext.request.contextPath}/AddShop"><button>Add Shop</button></a></td>
				<td><a href = "${pageContext.request.contextPath}/ViewShop"><button>View Shop</button></a></td>
			</tr>
			
			<tr>
				<td>Product Master:</td>
				<td><a href = "${pageContext.request.contextPath}/AddProduct"><button>Add Product</button></a></td>
				<td><a href = "${pageContext.request.contextPath}/ViewProduct"><button>View Product</button></a></td>
			</tr>
			
			<tr>
				<td>Add Sale:</td>
				<td><a href = "${pageContext.request.contextPath}/AddSale"><button>Add Sale</button></a></td>
				<td><a href = "${pageContext.request.contextPath}/ViewSale"><button>View Sale</button></a></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3"><center>@Copyright CSM</center></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>