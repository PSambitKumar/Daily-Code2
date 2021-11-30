

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

@WebServlet("/ProductMaster")
public class ProductMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String pname = request.getParameter("productname");
		String pdesc = request.getParameter("productdesc");
		String pprice = request.getParameter("productprice");
		int pprice1 = Integer.parseInt(pprice);
//		out.print(pname+pdesc+pprice);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "call insertintopm(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setString(2, pdesc);
			ps.setInt(3, pprice1);
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
