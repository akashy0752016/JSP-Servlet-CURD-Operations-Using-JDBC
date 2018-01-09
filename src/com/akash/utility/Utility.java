package com.akash.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
	private static Connection con = null;
	
	public static Connection getConnection() throws SQLException {
		if(con == null || con.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate", "root", "root");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection() throws SQLException {
		if(con != null || !con.isClosed()) {
			con.close();
		}
	}
}
