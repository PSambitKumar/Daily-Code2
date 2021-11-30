<%@ page  import = "java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String s = request.getParameter("val");
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
PreparedStatement ps = con.prepareStatement("SELECT address FROM registration WHERE name=?");
ps.setString(1,s);
ResultSet rs = ps.executeQuery();
while(rs.next()){
	String address = rs.getString(1);
	out.println(address);
}
%>
</body>
</html>