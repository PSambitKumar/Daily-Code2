

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
import javax.servlet.http.HttpSession;


@WebServlet("/order_process")
public class order_process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession(true);
		PrintWriter out= response.getWriter();
		String orderid = request.getParameter("orderid");
		String name = request.getParameter("name");
		String orderdate = request.getParameter("orderdate");
		String status = request.getParameter("status");
		out.println(orderid+name+orderdate+status);
		
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
			out.println("Connected");
			PreparedStatement ps = con.prepareStatement("INSERT INTO order_master(orderid, orderdate, customerid, orderstatus) VALUES(?,?,?,?)");
		
			ps.setString(1, orderid);
			ps.setString(2, name);
			ps.setString(3, orderdate);
			ps.setString(4, status);
			 int x = ps.executeUpdate();	
			 if(x >0) {
				 sess.setAttribute("a", orderid);
				 ServletContext sc = getServletContext();
			        RequestDispatcher rd = sc.getRequestDispatcher("/order_detail.jsp");
			        rd.forward(request,response);
			 }
	}
	catch(Exception e) {
		out.println(e);
	}
	}
}
