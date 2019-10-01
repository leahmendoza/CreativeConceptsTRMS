package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
private static Connection conn;
	
	public static Connection getConnection() {
		
		try {
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(
					System.getenv("databaseurl"),
					System.getenv("databaseusername"),
					System.getenv("databasepassword")
					);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
