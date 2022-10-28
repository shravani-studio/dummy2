package App;

import java.sql.SQLException;

import Controller.UserController;

public class Driver {
	public static void main(String args[]) throws SQLException {
		UserController usercntl = new UserController();
		usercntl.add();
		usercntl.show();
		usercntl.update();
		usercntl.delete();
		
	}
}
