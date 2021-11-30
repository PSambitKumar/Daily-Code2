<%@ page import = "java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style2.css"/>
	<title>Product Master</title>
</head>
<body>


<form action ="ProductMaster" method="post">
	<div class="login-div">
		<div class="logo"></div>
		<div class="title">CSM Product Master</div>
		<div class="fields">
			<div class="productname"><input type="text" name="productname" placeholder="Product Name"></div>
			<div class="productdesc"><input type="text" name="productdesc" placeholder="Product Descrption"></div>
			<div class="productprice"><input type="number" name="productprice" placeholder="Product Price"></div>
		</div>
		<div class="submit-button1"><input type="submit" value="Submit"></div>
		<div class="cancel-button1"><input type="submit" value="Cancel"></div>
	</div>

</form>



<%!
int max_rid, i;
%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
	PreparedStatement ps = con.prepareStatement("SELECT MAX(ProductID) FROM productmaster");
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		max_rid = rs.getInt(1);
		//out.print(max_rid);
	}
%>





<div class="table">

	<table align="center" cellspacing ="0" >
		<tr>
			<th>Product_ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Action</th>
		</tr>

		<%
			for(i=1; i<=max_rid; i++){
				Class.forName("com.mysql.jdbc.Driver");
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
				//out.println("connected");
				PreparedStatement ps1 = con.prepareStatement("SELECT ProductID, ProductName, ProductDesc, ProductPrice FROM productmaster WHERE ProductID=?");
				ps1.setInt(1, i);
				ResultSet rs1 = ps1.executeQuery();

				while(rs1.next()){
					int x = rs1.getInt(1);
		%>
		<tr>
			<td><%out.println("PID-2021-"+rs1.getInt(1)); %></td>
			<td><%out.println(rs1.getString(2)); %></td>
			<td><%out.println(rs1.getString(3)); %></td>
			<td><%out.println(rs1.getInt(4)); %></td>
			<td><form action="Delete">
				<input type="hidden" name="delindex" value="<%=x%>">
				<%-- <label><%=x %></label> --%>
				<input class="delete-button1" type="submit" name="add" value="Delete">
			</form>

				<form action="Edit.jsp" >
					<input type="hidden" name="delindex1" value="<%=x%>">
					<%-- <label><%=x %></label> --%>
					<input class="edit-button1" type="submit" name="add1" value="Edit">
				</form>
			</td>
		</tr>
		<%
				}
			}
		%>

	</table>

</div>
</body>
</html>