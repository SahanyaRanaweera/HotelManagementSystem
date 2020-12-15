package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDBUtil {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet res = null;

	// create method to validate login
	public static List<User> validateLogin(String username, String password) {

		ArrayList<User> user = new ArrayList<>();
		try {

			// create database connection
			conn = DBConnect.connect();
			// executing query to validate user
			stmt = conn.createStatement();
			String sql = "select * from user where username='" + username + "' and password ='" + password + "'";
			res = stmt.executeQuery(sql);
			// creating user object with retrieved data
			if (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String email = res.getString(4);
				String phone = res.getString(5);
				String nic = res.getString(6);
				String utype = res.getString(9);

				User user1 = new User(id, name, address, email, phone, nic, username, password, utype);
				user.add(user1);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// closing
		}

		return user;
	}
	public static boolean addUser(String name, String address, String email, String phone, String nic, String username, String password, String type) {
		boolean success = false;
		try {
			// create database connection
			conn = DBConnect.connect();
			
			stmt = conn.createStatement();
			String sql = "insert into user values (0, '"+name+"', '"+address+"', '"+email+"', '"+phone+"', '"+nic+"', '"+username+"', '"+password+"', '"+type+"')";
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				success = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
	public static boolean deleteUser(String username) {
		boolean success = false;
		try {
			// create database connection
			conn = DBConnect.connect();
			// executing query to validate user
			stmt = conn.createStatement();
			String sql = "delete from user where username = '"+username+"'";
			int r= stmt.executeUpdate(sql);
			if (r > 0) {
				success = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	public static List<User> getUserlist(){
		ArrayList<User> users = new ArrayList<>();
		try {
			// create database connection
			conn = DBConnect.connect();
			// executing query to validate user
			stmt = conn.createStatement();
			String sql = "select * from user";
			res = stmt.executeQuery(sql);
			while (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String email = res.getString(4);
				String phone = res.getString(5);
				String nic = res.getString(6);
				String username = res.getString(7);
				String password = res.getString(8);
				String type = res.getString(9);
				User u = new User(id, name, address, email, phone, nic, username, password, type);
				users.add(u);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}
