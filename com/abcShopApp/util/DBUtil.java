package com.abcShopApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/wiprobatch5db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "route123";
	
	public static Connection getDBConnection() {
		
		Connection con = null;
		
		try {
			// Step1 : Load the driver
			Class.forName(DRIVER_NAME);
			System.out.println("Driver Loaded");

			// Step 2: Establish the connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection established");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}