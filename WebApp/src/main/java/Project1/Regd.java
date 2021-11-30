package Project1;

//import Project1.getset;
//import Project1.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;


@WebServlet("/Regd")
public class Regd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    String username, password, name, address, a, gender;
	    String sql1 = "call insertIntoRegistration(?,?,?,?)";
	    String sql2 = "call insertIntoLogin(?,?)";
	    int age, re1, re2;
	    Connection con = null;
	    PreparedStatement ps = null;
	    PreparedStatement ps1 = null;
	    
        try {
            username = request.getParameter("username");
            password = request.getParameter("password");
            name = request.getParameter("name");
            address = request.getParameter("address");
            a = request.getParameter("age");
            age = Integer.parseInt(a);
            gender = request.getParameter("gender");
			
            con = JDBCConnection.initialize();
            
           //ps = con.prepareStatement("INSERT INTO registration(name, address, age, gender) VALUES(?,?,?,?)");
            ps = con.prepareStatement(sql1);
		    ps.setString(1,name);
		    ps.setString(2,address);
		    ps.setInt(3,age);
		    ps.setString(4,gender);
		    re1 = ps.executeUpdate();
		    String rpass = Integer.toString(re1);
		    
		    //ps1 = con.prepareStatement("INSERT INTO login(username, password) VALUES(?,?)");
		    ps1 = con.prepareStatement(sql2);
		    ps1.setString(1,username);
		    ps1.setString(2,password);
		    re2 = ps1.executeUpdate();
		    
		    //getset g = new getset();
		    //g.setResult1(re1);
		    //g.setResult2(re2);
		    
		    HttpSession sess = request.getSession(true);
		    sess.setAttribute("p1",rpass );
		    
			
			 if(re1 > 0 && re2 >0) { 
			//String success = "Registration Succesful";
			//sess.setAttribute("p2", success);
			  ServletContext sc = getServletContext();
			  RequestDispatcher rd = sc.getRequestDispatcher("/WelcomeRegistration.jsp");
			  //RequestDispatcher rd = sc.getRequestDispatcher("/Regd.jsp.jsp");
			  rd.forward(request,response); }
			 
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}
}
