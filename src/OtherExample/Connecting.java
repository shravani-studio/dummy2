package OtherExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {
	static Connection c;
	//constructor
	public Connecting() throws SQLException {
		super();
		set_connection();
	}
	
	
	 void set_connection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   Connection get_connection() {
		return c;
	}
}
