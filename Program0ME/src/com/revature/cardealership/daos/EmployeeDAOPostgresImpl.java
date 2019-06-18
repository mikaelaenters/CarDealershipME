package com.revature.cardealership.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.postgresqlutil.ConnectionFactory;

public class EmployeeDAOPostgresImpl implements EmployeeDAO{

	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public void createEmployee(Employee employee) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into employee (username, user_password) values (?, ?)");
			pstmt.setString(1, employee.getUserId());
			pstmt.setString(2, employee.getPassword());
			
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Insert");

			pstmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public int getEmployeeKeyByUsername(String username) {
		int key = -1;

		String sql = "select employee_id from employee where username = '" + username + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				key = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return key;
	}

	@Override
	public boolean employeeValidation(String username, String password) {
		boolean valid = false;
		
		String sql = "select user_password from employee where username = '" + username + "'";
 
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				if(password.equals((rs.getString(1)))) {
					valid = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valid;
	}

}
