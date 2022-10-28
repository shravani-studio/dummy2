import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserChoice {
	Connection con;
	PreparedStatement p;
	
	//creating connection
	void connection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","root");
	}
	
	void insert(Scanner sc) throws SQLException {
		System.out.println("Enter user id");
		int id = sc.nextInt();
		System.out.println("Enter user name");
		String name = sc.next();
		System.out.println("Enter user email");
		String email = sc.next();
		String insertQuery = "insert into user values(?,?,?)";
		p = con.prepareStatement(insertQuery);
		p.setInt(1, id);
		p.setString(2, name);
		p.setString(3, email);
		p.executeUpdate();
		
	}
	
	void delete(Scanner sc) throws SQLException {
		System.out.println("Enter user id you want to delete");
		int id = sc.nextInt();
		String deleteQuery = "delete from user where uId = ?";
		p = con.prepareStatement(deleteQuery);
		p.setInt(1,id);
		p.executeUpdate();
	}
	
	void update(Scanner sc) throws SQLException {
		System.out.println("Enter user id");
		int id = sc.nextInt();
		System.out.println("Enter name you want to update");
		String uname = sc.next();
		System.out.println("Enter email you want to update");
		String uemail = sc.next();
		String updateQuery = "Update user set name=?,email=? where uId=?";
		p = con.prepareStatement(updateQuery);
		p.setString(1,uname);
		p.setString(2,uemail);
		p.setInt(3,id);
		p.executeUpdate();
	}
	
	void choice() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice...\n1.INSERT\n2.DELETE\n3.UPDATE\n4.EXIT");
		switch(sc.nextInt()) {
		case 1: connection();insert(sc);choice();break;
		case 2: connection();delete(sc);choice();break;
		case 3: connection();update(sc);choice();break;
		case 4:break;
		default: System.out.println("select correct option");
		}
	}
	public static void main(String args[]) throws SQLException {
		UserChoice uc = new UserChoice();
		uc.choice();
		uc.con.close();
	}
}
