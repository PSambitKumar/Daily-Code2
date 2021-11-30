package Project1;
import Project1.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginForword")
public class LoginForword<HttpSession> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		HttpSession sess = request.getSession(true);
		String username, password, usertype;
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		Vector v = new Vector();
		String sql1 = "call loginForword1(?,?)";
		String sql2 = "call loginForword2(?)";
		//String sql3 = "call loginForword3(?)";
		try {
			
			username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			
			con = JDBCConnection.initialize();
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, username);
			ps1.setString(2, password);
			rs = ps1.executeQuery();
			
			while(rs.next()) {
				int uid = rs.getInt(1);
				int reid =uid;
				ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, reid);
				rs1 = ps2.executeQuery();
			while(rs1.next()) {
				String usertype1 = rs1.getString(1);
				String status = rs1.getString(2);
				if(usertype1.equals("admin") && usertype1.equals(usertype) ) {
					v.add(reid);
					v.add(username);
					sess.setAttribute("vpass",v);
			        ServletContext sc = getServletContext();
			        RequestDispatcher rd = sc.getRequestDispatcher("/admin.jsp");
			        rd.forward(request,response);
					}
				else if(usertype1.equals("user") && usertype1.equals(usertype) && status.equals("approved") ) {
					v.add(reid);
					v.add(username);
					sess.setAttribute("vpass",v);
			        ServletContext sc = getServletContext();
			        RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
			        rd.forward(request,response);
					}
				else if(usertype1.equals("user") && usertype1.equals(usertype) && status.equals("notapproved") ) {
			        ServletContext sc = getServletContext();
			        RequestDispatcher rd = sc.getRequestDispatcher("/notapproveduser.jsp");
			        rd.forward(request,response);
					}
				else{
						out.println("Incorrect Username and Password");
					}
				}
			}
		}
		catch(Exception e) {
			//out.println("You need to Register");
			out.println(e);
		}
	}
}
