

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = null;
		String data1 = null;
		HttpSession sess = request.getSession(true);
		PrintWriter out= response.getWriter();
		
		int userid = (Integer)sess.getAttribute("a1");
		String username = (String)sess.getAttribute("a2");
		String password = (String)sess.getAttribute("a3");
		String useradd = request.getParameter("useradd");
		String usergender = request.getParameter("usergender");
		String userphn = request.getParameter("userphn");
		String useremail = request.getParameter("useremail");
		String userdob = request.getParameter("userdob");
		
		//out.println(userid+username+password+useradd+usergender+userphn+useremail+userdob);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "UPDATE user_master SET useradd=?, usergender=?, userphn=?, useremail=?, userdob=? WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, useradd);
			ps.setString(2, usergender);
			ps.setString(3, userphn);
			ps.setString(4, useremail);
			ps.setString(5, userdob);
			ps.setInt(6, userid);
			int update = ps.executeUpdate();
			
			if(update > 0) {
				 data = "Profile Updated!!"; RequestDispatcher rd; request.setAttribute("s1",
				 data); rd = request.getRequestDispatcher("/EditProfile.jsp");
				 rd.forward(request, response);
			}
			else {
				 data1 = "Profile Update Failed!!"; RequestDispatcher rd1;
				 request.setAttribute("s2", data1); rd1 =
				 request.getRequestDispatcher("/EditProfile.jsp"); rd1.forward(request,
				 response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
