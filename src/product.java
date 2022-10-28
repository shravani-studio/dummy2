import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class product {
	public static void main(String args[]) throws SQLException {
		//register driver
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		//get connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy", "root","root");

		//create statement
		Statement st = con.createStatement();
		
		//execute query
		st.executeUpdate("insert into user values(2,'shravani','s@gmail.com')");
		ResultSet rs = st.executeQuery("select * from user");
		
		while(rs.next()) {
			System.out.println(rs.getInt("uId")+" "+rs.getString("name")+" "+rs.getString("email"));
		}
		st.close();
		rs.close();
		con.close();
		
		
	}
}
