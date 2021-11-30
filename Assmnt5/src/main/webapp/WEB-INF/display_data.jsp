

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/display_data")
public class display_data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int max_rid;
		HttpSession sess = request.getSession(true);
		PrintWriter out= response.getWriter();
		String orderid =(String)sess.getAttribute("x1");
		String name = request.getParameter("name");
		String rate = request.getParameter("rate");
		int rate1 = Integer.parseInt(rate);
		String quantity = request.getParameter("quantity");
		int quantity1 = Integer.parseInt(quantity);
		
		try {		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
			out.println("Connected");
			PreparedStatement ps = con.prepareStatement("insert INTO order_master(orederid, productid, productrate, productquantity) VALUES(?,?,?,?)");
			ps.setString(1, orderid);
			ps.setString(2, name);
			ps.setInt(3, rate1);
			ps.setInt(4, quantity1);
			ps.executeQuery();
		}
		catch(Exception e) {
			out.println(e);
		}
		

			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
			PreparedStatement ps1 = con1.prepareStatement("SELECT MAX(slno) FROM product_details");
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()){
				max_rid = rs1.getInt(1);
			}

			<form action="Report.jsp">
			%>
			<table  cellspacing="0">
			<tr>
			<th>SL No</th>
			<th>Order ID</th>
			<th>Product Name</th>
			<th>Product Rate</th>
			<th>Product Quantity</th>
			</tr>
		<%
		try {
			for(int i=1; i<=max_rid; i++){
				Class.forName("com.mysql.jdbc.Driver");
				Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");
				PreparedStatement ps2 = con2.prepareStatement("SELECT name, address, age, gender, status FROM registration WHERE rid=?");
				ps2.setInt(1, i);
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()){
					%>
					<tr>
				<td><%out.println(rs2.getInt(1)); %></td>
				<td><%out.println(rs2.getString(2)); %></td>
				<td><%out.println(rs2.getString(3)); %></td>
				<td><%out.println(rs2.getInt(4)); %></td>
				<td><%out.println(rs2.getInt(5)); %></td>
				</tr>
					<%
				}
			}
			%>
			<tr>
			<td colspan="6"><input type="submit" name = "radiovalue" value="Submit"></td>
			</tr>
			</table>
		}
		catch(Exception e) {
			out.println(e);
		}
		</form>
		
		
	}

}
