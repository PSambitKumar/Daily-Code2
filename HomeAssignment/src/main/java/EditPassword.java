

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


@WebServlet("/EditPassword")
public class EditPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		PrintWriter out= response.getWriter();
		
		String currpass = request.getParameter("currpass");
		String newpass = request.getParameter("newpass");
		String newpass1 = request.getParameter("newpass1");
		int userid = (Integer)sess.getAttribute("b1");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "SELECT userpass FROM user_master WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userpass = rs.getString(1);
				
				if(userpass.equals(currpass)) {
					if(newpass.equals(newpass1)) {
						PreparedStatement ps1 = con.prepareStatement("UPDATE user_master SET userpass=? WHERE userid=?" );
						ps1.setString(1, newpass);
						ps1.setInt(2, userid);
						int result = ps1.executeUpdate();
						if(result > 0) {
							String data = "Password Updated!!"; 
							RequestDispatcher rd; request.setAttribute("k1",data); 
							rd = request.getRequestDispatcher("/EditPassword.jsp");
							rd.forward(request, response);
						}
					}
					else {
						String data = "New Password Doesn't Match!!"; 
						RequestDispatcher rd; request.setAttribute("k1",data); 
						rd = request.getRequestDispatcher("/EditPassword.jsp");
						rd.forward(request, response);
					}
				}
				else {
					String data = "Current Password Doesn't Match!!"; 
					RequestDispatcher rd; request.setAttribute("k1",data); 
					rd = request.getRequestDispatcher("/EditPassword.jsp");
					rd.forward(request, response);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
