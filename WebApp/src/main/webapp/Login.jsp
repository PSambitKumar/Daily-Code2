
<%@ page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <center>
        <h3>Login Page</h3>
        <form action="LoginForword">

            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" placeholder="username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="password"></td>
                </tr>
                <tr>
                    <td>User Type:</td>
                    <td><input type="radio" value="admin" name="usertype" checked > Admin
                        <input type="radio" value="user" name="usertype"> User</td>
                </tr>
                <tr>
                    <td colspan="2"><center><input type="submit" name="b1" value="Login Here"></center></td>
                </tr>
            </table>

            New User:<a href="Regd.jsp">Register Here</a>

        </form>
    </center>
    
<%--         <%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String a = request.getParameter("age");
    int age = Integer.parseInt(a);
    String gender = request.getParameter("gender");
    
    
    %> --%>
    
</body>
</html>
