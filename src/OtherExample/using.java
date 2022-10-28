package OtherExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class using{
	public static void main(String args[]) throws SQLException {
		Connecting cnt = new Connecting();
		try{
			Statement st = cnt.get_connection().createStatement();
		    ResultSet rs = st.executeQuery("select * from user");
		    while(rs.next()) {
				System.out.println(rs.getInt("uId")+" "+rs.getString("name")+" "+rs.getString("email"));
			}
		    //System.out.println(rs);--> will not give table info
		}
		catch(Exception e) {
			
		}
	}
}
