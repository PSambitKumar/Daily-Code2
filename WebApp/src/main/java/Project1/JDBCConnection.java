package Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	protected static Connection initialize() throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sambit_db";
        String user = "root";
        String pass = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,pass);
		return con;
	}
}

