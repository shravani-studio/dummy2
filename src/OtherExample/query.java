package OtherExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class query {
	Statement st;
	ResultSet rs;
	ResultSet selection() {
	    try {
	    	Connecting cnt = new Connecting();
	    	st = cnt.get_connection().createStatement();
			rs = st.executeQuery("select * from user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return rs;
	}
}
