<%@ page session="true" import="java.util.*"  import="p1.Album"%>
<html>
<body>

<%!
Album s1;
%>
<% 
Vector vec=(Vector)session.getAttribute("x1");
if(vec!=null)
{


Object ob = session.getAttribute("x1");
Vector v =(Vector)ob;
%>
<table border="2px">
<tr>
<td>Album Name</td> <td>Artist Name</td> <td>Country Name</td><td>Price</td><td>Quantity</td><td>Delete here</td>
</tr>
<% for(int i=0;i<v.size();i++)
{
	Object ob1=v.elementAt(i);
	 s1=(Album)ob1;
	%>
	
	<tr>
	<td><%=s1.getAlbum()%></td><td><%=s1.getArtist()%></td><td><%=s1.getCountry()%></td><td><%=s1.getPrice()%></td>
	<td><%=s1.getQty()%></td>
	<td>
	<form action="ServletEx1">
	<input type="submit" name="add" value="Delete">
	<input type="hidden" name="delindex" value="<%=i%>">
	
	</td></tr>
	</form>
	
	
	
<% }%>
</table>
<form action="exxx1.jsp">
<input type="submit" value="Select">

</form>
<% }%>
</body>
</html>