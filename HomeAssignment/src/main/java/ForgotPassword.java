
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Mail;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		PrintWriter out= response.getWriter();
		
		String userid1 = request.getParameter("userid");
		int userid = Integer.parseInt(userid1);
		String useremail = request.getParameter("useremail");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "SELECT userid, useremail FROM user_master";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userid2 = rs.getInt(1);
				String useremail2 = rs.getString(2);
				if(userid2 == userid && useremail2.equalsIgnoreCase(useremail)) {
					
					Mail1 ob = new Mail1();
					ob.sendEmailTLS(useremail2);
					
					String data = "Mail Sent Successful. Check Your Email"; 
					RequestDispatcher rd; request.setAttribute("d1",data); 
					rd = request.getRequestDispatcher("/ForgetPassword.jsp");
					rd.forward(request, response);
				}
				else {
					String data = "Incrrect User ID and Email Address!!"; 
					RequestDispatcher rd; request.setAttribute("d1",data); 
					rd = request.getRequestDispatcher("/ForgetPassword.jsp");
					rd.forward(request, response);
				}
			}
		}
			catch(Exception e) {
			out.println("Incorrect User ID!!");
		}
	}
}
