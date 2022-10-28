package OtherExample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class queryExe {
	public static void main(String args[]) throws SQLException {
		query q = new query();
		ResultSet result = q.selection();
		while(result.next()) {
			System.out.println(result.getInt("uId")+" "+result.getString("name")+" "+result.getString("email"));
		}
	}
}
