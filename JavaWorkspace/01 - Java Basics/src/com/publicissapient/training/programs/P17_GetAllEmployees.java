package com.publicissapient.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.publicissapient.training.utils.DbUtil;

public class P17_GetAllEmployees {

	public static void main(String[] args) throws Exception{
		
		String sql = "select * from employees";
		try(
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while(rs.next()) {
				// inside the loop, rs points to a single row
				String name = rs.getString(2); // 2nd column
				String email = rs.getString("email");
				double salary = rs.getDouble("salary"); // column name
				int id = rs.getInt(1); // column position
				
				System.out.printf("%4d %-25s %-25s %10.2f\n",
						id, name, email, salary);
			}
		}
		finally {
		}
		
	}
}
