package JDBCWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

import model.User;

public class UserJDBC {
	static Connection c;
	static Statement st;
	static PreparedStatement p;
	public static void openConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy", "root", "root");
		st = c.createStatement();
	}
	public static void insert(User u) throws SQLException {
		String query = "insert into user values(?,?,?)";
		p = c.prepareStatement(query);
		p.setInt(1, u.getId());
		p.setString(2, u.getName());
		p.setString(3, u.getEmail());
		p.executeUpdate();
	}
	public static void select() throws SQLException {
		st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
		
		while(rs.next()) {
			System.out.println(rs.getInt("uId")+" "+rs.getString("name")+" "+rs.getString("email"));
		}
		
	}
	public static void update(User u) throws SQLException {
		String query = "update user set name=?,email=? where uId=?";
		p=c.prepareStatement(query);
		p.setString(1,u.getName());
		p.setString(2,u.getEmail());
		p.setInt(3,u.getId());
		p.executeUpdate();
	}
	public static void delete(int id) throws SQLException {
		String query = "delete from user where uId=id";
		p = c.prepareStatement(query);
		p.setInt(1,id);
		p.executeUpdate();
	}
	
	
}
