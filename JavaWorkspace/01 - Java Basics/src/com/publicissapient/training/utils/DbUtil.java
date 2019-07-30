package com.publicissapient.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {

	private DbUtil() {
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("com.publicissapient.training.utils.jdbc-info");
		String url = rb.getString("jdbc.url"), 
				username = rb.getString("jdbc.username"), 
				password = rb.getString("jdbc.password"), 
				driver = rb.getString("jdbc.driver_class_name");
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
}
