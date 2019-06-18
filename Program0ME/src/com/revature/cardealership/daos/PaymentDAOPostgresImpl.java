package com.revature.cardealership.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.cardealership.pojo.Payment;
import com.revature.cardealership.postgresqlutil.ConnectionFactory;

public class PaymentDAOPostgresImpl implements PaymentDAO {
	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public void createPayment(int carId, double paymentAmount) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into payment(car_id, payment_amount)" + " values (?, ?)");
			pstmt.setInt(1, carId);
			pstmt.setDouble(2, paymentAmount);
		
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> allPayments = new ArrayList<Payment>();
		
		String sql = "select * from payment";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //Loops through every row 
				allPayments.add(new Payment(rs.getInt(1), rs.getDouble(3), rs.getInt(2))); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allPayments;
	}

	@Override
	public List<Payment> getPaymentsByCarId(int carId) {
		List<Payment> allCarPayments = new ArrayList<Payment>();
		String sql = "select * from payment where car_id = " + carId;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //Loops through every row 
				allCarPayments.add(new Payment(rs.getInt(1), rs.getDouble(3), rs.getInt(2))); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allCarPayments;
	}

	
}
