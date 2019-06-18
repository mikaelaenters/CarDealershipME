package com.revature.cardealership.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.postgresqlutil.ConnectionFactory;
import com.revature.cardealership.utilities.LoggingUtility;

public class OfferDAOPostgresImpl implements OfferDAO{

	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public void createOffer(Offer offer) {         //Create a new offer 
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into offer(customer_id, car_id, offer_amount) values (?, ?, ?)");
			pstmt.setInt(1, offer.getCustomerId());
			pstmt.setInt(2, offer.getCarId());
			pstmt.setDouble(3, offer.getOfferAmount());
			
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");

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
		
//		try {
//			
//			String sql = "insert into offer(customer_id, car_id, offer_amount) values (" + offer.getCustomerId()
//					+ ", " + offer.getCarId() + ", " + offer.getOfferAmount() + ")";
//			
//			Statement stmt;
//				stmt = conn.createStatement();
//
//				conn.setAutoCommit(false);  //needs to be done to run transactions
//				Savepoint sp = conn.setSavepoint("Before Update");
//				int numberOfRows = stmt.executeUpdate(sql);
//				
//				if (numberOfRows > 1) {
//						conn.rollback(sp);
//						LoggingUtility.error("Too many rows affected");
//				}
//
//			conn.commit();
//			conn.setAutoCommit(true);
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
	}

	@Override
	public void updateRejected(int offerId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update offer set offer_status = 3 where offer_id = ?");
			pstmt.setInt(1, offerId);
	
			pstmt.execute();
			
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");

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
	public void updateAccepted(int offerId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update offer set offer_status = 2 where offer_id = ?");
			pstmt.setInt(1, offerId);
	
			pstmt.execute();
			
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");

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
	public List<Offer> getAllPendingCarOffers(int carId) {
		List<Offer> pendingOffers = new ArrayList<Offer>();
		
	String sql = "select * from offer where car_id = " + carId + " and offer_status = 1";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { //Loops through every row 
				pendingOffers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pendingOffers;
	}

	@Override
	public Offer getOfferById(int offerId) {
		
		Offer newOffer = null;
		
		String sql = "select * from offer where offer_id = " + offerId;
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) { 
				newOffer = new Offer(rs.getInt(2), rs.getInt(3), rs.getDouble(4)); //These are the columns
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newOffer;
	}

	@Override
	public List<Offer> getAllPendingOffers() {
		List<Offer> pendingOffers = new ArrayList<Offer>();
		
		String sql = "select * from offer where offer_status = 1";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { //Loops through every row 
				pendingOffers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4))); //These are the columns
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pendingOffers;
	}

	
}
