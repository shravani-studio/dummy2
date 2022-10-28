package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import model.User;
import sevice.UserService;

public class UserController {
	Scanner sc = new Scanner(System.in);
	
	UserService userser = new UserService();
	
	public void add() throws SQLException {
		System.out.println("Enter user id");
		int id = sc.nextInt();
		System.out.println("Enter user name");
		String name = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		
		User u = new User(id, name, email);
		userser.addData(u);
	}

	public void show() throws SQLException {
		
		userser.showData();
	}

	public void update() throws SQLException {
		System.out.println("Enter user id");
		int id = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		
		User u = new User(id, name, email);
		userser.updateData(u);
		
	}

	public void delete() throws SQLException {
		System.out.println("Enter user id you want to delete");
		int id = sc.nextInt();
		
		userser.deleteData(id);
		
	}

	
}
