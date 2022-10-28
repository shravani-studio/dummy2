package sevice;

import java.sql.SQLException;

import JDBCWork.UserJDBC;
import model.User;

public class UserService {
	
	public UserService() {
		super();
		// TODO Auto-generated constructor stub
		try {
			UserJDBC.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addData(User u) throws SQLException {
		UserJDBC.insert(u);
	}

	public void showData() throws SQLException {
		UserJDBC.select();
		
	}

	public void updateData(User u) throws SQLException {
		UserJDBC.update(u);
		
	}

	public void deleteData(int id) throws SQLException {
		UserJDBC.delete(id);
	}

	
}
