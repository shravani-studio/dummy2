import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

public class InsertDateTimeinJdbc {
	
	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy2","root","root");
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			java.sql.Time sqlTime = new java.sql.Time(date.getTime());
			//java.sql.Time sqlTime =  new Time.parse("12:00");
			//long time = java.sql.Time.parse("12:00")
			//PreparedStatement ps = new prepareStatement("insert into dtex values()");
	        System.out.println(sqlDate);
	        System.out.println(sqlTime);
	        
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
