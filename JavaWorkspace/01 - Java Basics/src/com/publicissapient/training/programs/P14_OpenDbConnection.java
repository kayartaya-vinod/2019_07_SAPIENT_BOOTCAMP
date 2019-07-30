package com.publicissapient.training.programs;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class P14_OpenDbConnection {
	
	public static void main(String[] args) throws Exception{
		
		// loading any JDBC driver class will automatically
		// instantiates itself and registers the newly created
		// instance with java.sql.DriverManager
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// MySQL, H2, MS-SQL, Postgresql do this when the jar is
		// added to the classpath
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		System.out.println("Drivers registered with DriverManager: ");
		while(drivers.hasMoreElements()) {
			Driver d = drivers.nextElement();
			System.out.println(d.getClass().getName());
		}
		
		String url = "jdbc:mysql://localhost:3306/northwind";
		String username = "root";
		String password = "Welcome#123";
		
		url = "jdbc:h2:tcp://localhost/~/PS_Training";
		username = "sa";
		password = "";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Got a connection of type: " + conn.getClass().getName());
		
	}

}
