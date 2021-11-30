<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style> 


input[type=button], input[type=submit], input[type=reset] {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<script type="text/javascript">

function validate()
{
var proname=document.getElementById("prname");
var prodesc=document.getElementById("prdesc");
if(onlyAlpha(proname,"Product Name must Fillup!!"))
{
	if(onlyAlpha(prodesc,"Product Description must Fillup!!"))
	{
	return true;
}
}
return false;
}

function onlyAlpha(elem,msg)
{
var exp=/^[ a-zA-Z]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}
</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form onsubmit="return validate()" action="ProductMaster" method ="post" ><br>
	
		<table align="center" border="1" cellspacing="0">
		
		<tr>
		<td>Product Name:</td>
		</tr>
		<tr>
		<td><input type="text" id = "prname" name="productname"></td>
		</tr>
		
		<tr>
		<td>Product Description:</td>
		</tr>
		<tr>
		<td><input type="text" name="productdesc"></td>
		</tr>
		
		<tr>
		<td>Product Price:</td>
		</tr>
		<tr>
		<td><input type="number" name="productprice"></td>
		</tr>
		
		<tr>
		<td><input type = "submit" value = "Save Product"><input type='submit' value = "Cancel"></td>
		</tr>
		
		</table>
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
		<br><br>
		
		<table align="center" border="1" cellspacing ="0" >
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
			<td><%out.println(rs1.getInt(1)); %></td>
			<td><%out.println(rs1.getString(2)); %></td>
			<td><%out.println(rs1.getString(3)); %></td>
			<td><%out.println(rs1.getInt(4)); %></td>
			<td><form action="Delete">
				<input type="hidden" name="delindex" value="<%=x%>">
				<label><%=x %></label>
				<input type="submit" name="add" value="Delete"></form>
				</td>
			</tr>
				<%
			}
		}
		%>
		
		</table>
		
		
	
		
		
</body>
</html>