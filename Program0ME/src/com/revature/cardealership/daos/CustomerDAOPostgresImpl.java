package com.revature.cardealership.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.postgresqlutil.ConnectionFactory;

public class CustomerDAOPostgresImpl implements CustomerDAO{

	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public void createCustomer(Customer customer) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into customer (username, user_password) values (?, ?)");
			pstmt.setString(1, customer.getUserId());
			pstmt.setString(2, customer.getPassword());
			pstmt.execute();
		} catch (SQLException e) {
			
		}
	}

	@Override
	public int getCustomerKeyByUsername(String username) {
		int key = -1;

		String sql = "select customer_id from customer where username = '" + username +"'";

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
	public boolean customerValidation(String username, String password) {
		boolean valid = false;
		
		String sql = "select user_password from customer where username = '" + username + "'";
 
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
