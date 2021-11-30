import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession sess = request.getSession(true);
		String username, password;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "SELECT * FROM user_master WHERE username=? AND userpass=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				sess.setAttribute("x1", username);
				sess.setAttribute("x2", password);
				ServletContext sc = getServletContext();
		        RequestDispatcher rd = sc.getRequestDispatcher("/user.jsp");
		        rd.forward(request,response);
			}
			else {
				out.println("Wrong Username and Password!!");
			}


			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
