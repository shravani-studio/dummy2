


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

 

public class DateTimeExample_IMP {

public static void main(String args[]) throws ParseException, SQLException{
	Scanner sc = new Scanner(System.in);
//	java.util.Date date=new java.util.Date();
//	
//	java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//	java.sql.Time sqlTime=new java.sql.Time(date.getTime());
//	System.out.println(sqlTime);
//	
	SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat s2 = new SimpleDateFormat("HH:mm");
//	java.util.Date date1=s1.parse("2022-10-23");
//	java.util.Date date2=s2.parse("02:43");
	java.util.Date date1=s1.parse(sc.next());
	java.util.Date date2=s2.parse(sc.next());
	java.sql.Date sqlDate2=new java.sql.Date(date1.getTime());
	java.sql.Time sqlTime2=new java.sql.Time(date2.getTime());
	System.out.println(sqlDate2);
	System.out.println(sqlTime2);
	int no=4;
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy2", "root", "root");
	Statement st = c.createStatement();
	PreparedStatement pst=c.prepareStatement("insert into dtex values(?,?,?)");
	pst.setDate(1, sqlDate2);
	pst.setTime(2, sqlTime2);
	pst.setInt(3, no);
	pst.executeUpdate();
}
}





