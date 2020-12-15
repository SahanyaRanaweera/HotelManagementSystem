package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//declaring static variables to store database url and credentials
	private static String url = "jdbc:mysql://localhost:3306/hotel";
	private static String username = "root";
	private static String password = "Zhan1005";
	private static Connection conn;
	
	//creating method to return Connection type object
	public static Connection connect() {
		try {
			//register jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//create database connection
			conn = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) {
			System.out.println("Database connection failure");
		}
		
		return conn;
	}
}
