	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.StringTokenizer"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form>	
		<h3>Choose your Album</h3><br>
		<select name="album">
		<option value="none" selected disabled hidden>Select an Option</option>
  			<option value="A-Sambit-India-1000">A-Sambit-India-1000</option>
  			<option value="B-Hrusi-Austrilia-2000">B-Hrusi-Austrilia-2000</option>
  			<option value="C-Trupti-USA-3000">C-Trupti-USA-3000</option>
			<option value="D-Jyoti-UK-4000">B-Hrusi-Austrilia-4000</option>
		</select>
		
		Enter quantity:<input type = "text" name = "t1">
		<button type="submit" onclick="myFunction()">Add</button>
		<br><br>
		
		<%
			String s1 ="";
			try{
				String q = request.getParameter("t1");
				int qty = Integer.parseInt(q);
				s1 = request.getParameter("album");
				StringTokenizer st = new StringTokenizer(s1, "-");
				String albumName = st.nextToken();
				String artist = st.nextToken();
				String country = st.nextToken();
				String p = st.nextToken();
				int price = Integer.parseInt(p);
			%>
				
				
		<script>
		function myFunction() {
			
  			var table = document.getElementById("myTable");
  			var row = table.insertRow(-1);
  			var cell1 = row.insertCell(0);
  			var cell2 = row.insertCell(1);
  			var cell3 = row.insertCell(2);
  			var cell4 = row.insertCell(3);
  			var cell5 = row.insertCell(4);
  			var cell6 = row.insertCell(5);
  			cell1.innerHTML ="Hello";
  			cell2.innerHTML ="Hello";
  			cell3.innerHTML ="Hello";
  			cell4.innerHTML ="Hello";
  			cell5.innerHTML ="Hello";
  			cell6.innerHTML ="Hello";
		}
		</script>
		
		<%
			}
			catch(Exception e){
				e.printStackTrace();
			}
			%>

		
		
	<table border="1" id="myTable" cellspacing="0">
		<tr>
			<th>Album</th>
			<th>Artist</th>
			<th>Country</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
			<th>Delete</th>
		</tr>	
     </table>
	</form>
</body>
</html>