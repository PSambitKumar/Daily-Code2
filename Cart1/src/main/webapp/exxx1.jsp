<%@ page session="true" import="java.util.*"  import="p1.Album"%>
<html>

<body>

<form action="ServletEx1" method="get">
<select name="t1">
<option>SELECT</option>
<option value="A|PK|Ind|Rs200">A|PK|Ind|Rs200</option>
<option value="B|CK|Ind|Rs200">B|CK|Ind|Rs200</option>
<option value="C|DK|Ind|Rs300">C|DK|Ind|Rs300</option>
<option value="D|FK|Ind|Rs800">D|FK|Ind|Rs800</option>
</select>
Quantity<input type="text" value=1 name="qty">
<input type="submit" name="add" value="click">


</form>
<jsp:include page="Next.jsp"/>
</body>
</html>