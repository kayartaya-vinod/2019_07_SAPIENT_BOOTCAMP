package com.publicissapient.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.publicissapient.training.utils.DbUtil;
import com.publicissapient.training.utils.KeyboardUtil;

public class P18_GetEmployeeById {

	public static void main(String[] args) throws Exception{
		
		int id = KeyboardUtil.getInt("Enter id: ");
		String sql = "select * from employees where empid = ?";
		
		ResultSet rs = null;
		
		try(
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		) {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("Name   = " + rs.getString("name"));
				System.out.println("Salary = Rs." + rs.getString("salary"));
				System.out.println("Email  = " + rs.getString("email"));
				System.out.println("Phone  = " + rs.getString("phone"));
				
			}
			else {
				System.out.println("Invalid id: " + id);
			}
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
		}
		
	}
}
