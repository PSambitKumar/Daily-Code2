

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/Regd")
public class Regd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid;
		String userid1, userphn, userpass, username, useradd, usergender, useremail, userdob;
		
		HttpSession sess = request.getSession(true);
		PrintWriter out= response.getWriter();
		
		userid1 = request.getParameter("userid");
		userid = Integer.parseInt(userid1);
		userpass = request.getParameter("userpass");
		username = request.getParameter("username");
		useradd = request.getParameter("useradd");
		usergender = request.getParameter("usergender");
		userphn = request.getParameter("userphn");
		useremail = request.getParameter("useremail");
		userdob = request.getParameter("userdob");
		
		Part userphoto = request.getPart("userphoto");
		String userPhotoName = userphoto.getSubmittedFileName();
		//out.println(userPhotoName);
		String uploadPath = "C:/Users/sambit.pradhan/eclipse-workspace/HomeAssignment/src/main/webapp/userphotos/"+userPhotoName;
		
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = userphoto.getInputStream();
			
			byte []data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");	
			String sql = "INSERT INTO user_master(userid, userpass, username, useradd, usergender, userphn, useremail, userdob, userphoto) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, userpass);
			ps.setString(3, username);
			ps.setString(4, useradd);
			ps.setString(5, usergender);
			ps.setString(6, userphn);
			ps.setString(7, useremail);
			ps.setString(8, userdob);
			ps.setString(9, userPhotoName);
			int update = ps.executeUpdate();
			
			if(update > 0) {
				out.println("Data Update!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
