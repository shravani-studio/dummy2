import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DateTimeEx {
	Date date;
	Time time;
	Connection c;
	PreparedStatement pst;
	Statement st;
	Connection openc() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy2", "root", "root");

		st = c.createStatement();
		
		return c;
	}
	
	void insert(Scanner sc) throws ParseException, SQLException {
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("");//format
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		System.out.println("Enter date in yyyy-MM-dd format");
		date = (Date) sdf1.parse(sc.nextLine());
		System.out.println("Enter time");
		time = (Time) sdf2.parse(sc.nextLine());
		
		String query = "insert into dtex values(?,?)";
		pst = c.prepareStatement(query);
		pst.setDate(1, date);
		pst.setTime(2, time);
		pst.setInt(3, 1);
		pst.executeUpdate();
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		DateTimeEx ex = new DateTimeEx();
		ex.openc();
		ex.insert(sc);
	}
}
