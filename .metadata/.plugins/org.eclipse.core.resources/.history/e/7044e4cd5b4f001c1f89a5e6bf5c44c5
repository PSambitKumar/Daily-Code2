

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		
		String a = request.getParameter("add");
		String b = request.getParameter("delindex");
		int c = Integer.parseInt(b);
		//out.println(a);
		//out.print(b);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "DELETE FROM productmaster WHERE ProductID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c);
			int update = ps.executeUpdate();
			
			if(update > 0) {
				
				 ServletContext sc = getServletContext();
			     RequestDispatcher rd = sc.getRequestDispatcher("/ProductMaster.jsp");
			     rd.forward(request,response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
