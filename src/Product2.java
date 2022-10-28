import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Product2 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		//register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//make connection
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","root");
		
		System.out.println("Enter id");
		int Id = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		
		String insertQuery = "insert into user values(?,?,?)";
		//prepare statement--when we don't know the values
		PreparedStatement p = c.prepareStatement(insertQuery);
		
		p.setInt(1,Id);
		p.setString(2,name);
		p.setString(3,email);
		
		int n = p.executeUpdate();
		System.out.println(n);
		
		c.close();
		sc.close();
	}
}
