package com.publicissapient.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.publicissapient.training.utils.DbUtil;
import com.publicissapient.training.utils.KeyboardUtil;

public class P16_AddPersonDataUsingPreparedStatement {
	
	public static void main(String[] args) throws Exception {
		
		String sql = "insert into persons (id, name, city, email) values(?, ?, ?, ?)";

		try(
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		) {
			conn.setAutoCommit(false);
			
			int id = KeyboardUtil.getInt("Enter id: ");
			String name = KeyboardUtil.getString("Enter name: ");
			String city = KeyboardUtil.getString("Enter city: ");
			String email = KeyboardUtil.getString("Enter email: ");
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, city);
			stmt.setString(4, email);
			
			stmt.execute(); // executeUpdate() --> DML, executeQuery()-->SELECT
			conn.commit();
		}
		finally {}
		
		System.out.println("Done!");
		
	}

}
