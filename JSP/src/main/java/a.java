import java.sql.*;

class ab {
    void a1() throws ClassNotFoundException, SQLException {

        String name = "Trupti";
        String address = "smbl";
        String age = "23";
        String gender = "female";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sambit_db","root","");


            PreparedStatement cs = con.prepareCall("INSERT INTO registration('name','address','age','gender') VALUES(?,?,?,?) ");
            cs.setString(1,name);
            cs.setString(2,address);
            cs.setString(3,age);
            cs.setString(4,gender);
            cs.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

public  class a{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ab ob = new ab();
        ob.a1();
    }
}

