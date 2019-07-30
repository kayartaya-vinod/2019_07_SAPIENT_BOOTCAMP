package com.publicissapient.training.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.publicissapient.training.utils.DbUtil;
import com.publicissapient.training.utils.KeyboardUtil;

public class P15_AddPersonData {
	
	public static void main(String[] args) throws Exception {
		

		try(
			Connection conn = DbUtil.getConnection();
			Statement stmt = conn.createStatement();
		) {
			conn.setAutoCommit(false);
			
			int id = KeyboardUtil.getInt("Enter id: ");
			String name = KeyboardUtil.getString("Enter name: ");
			String city = KeyboardUtil.getString("Enter city: ");
			String email = KeyboardUtil.getString("Enter email: ");
			
			String sql = String.format(
					"insert into persons values(%d, '%s', '%s', '%s')", 
					id, name, email, city);
			stmt.execute(sql); // executeUpdate() --> DML, executeQuery()-->SELECT
			conn.commit();
		}
		finally {}
		
		System.out.println("Done!");
		
	}

}
