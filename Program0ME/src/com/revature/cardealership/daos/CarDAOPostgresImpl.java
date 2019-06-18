package com.revature.cardealership.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.postgresqlutil.ConnectionFactory;
import com.revature.cardealership.utilities.LoggingUtility;

public class CarDAOPostgresImpl implements CarDAO {

	private static Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public void createCar(Car car) {        //Add New Car to Car Lot
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into car(make, model, car_year)" + " values (?, ?, ?)");
			pstmt.setString(1, car.getCarMake());
			pstmt.setString(2, car.getCarModel());
			pstmt.setInt(3, car.getCarYear());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCarOwner(int customerId, int carId) {            //Give Owner Their New Car
		try {
			PreparedStatement pstmt = conn.prepareStatement("update car set customer_id = ? where car_id = ?");
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, carId);
			
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
	public void updateCarActiveStatus(int carId) {      //Take Car Off Lot When Owned
		try {
			String sql = "{call update_car_active_status_procedure(?)}";
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");
			
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,carId);
			int numberOfRows = call.executeUpdate();

			if (numberOfRows > 1) {
				conn.rollback(sp);
				LoggingUtility.error("Too many rows affected");
			}	
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
	public void updateCarPrice(int carId, double price) {
		
		try {
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = conn.setSavepoint("Before Update");
			String sql = "update car set price = " + price + " where car_id = " + carId;
			int numberOfRows = stmt.executeUpdate(sql);
				
			if (numberOfRows > 1) {
					conn.rollback(sp);
					LoggingUtility.error("Too many rows affected");
			}
			
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
	public List<Car> getAllCarsOnLot() {                        //Cars on lot do not have price yet 
		List<Car> allCars = new ArrayList<Car>();
		String sql = "select * from car where active = true";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //Loops through every row 
				allCars.add(new Car(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(5))); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allCars;
		
	}

	@Override
	public Car getCarById(int carId) {
		Car newCar = new Car();
		
		String sql = "select * from car where car_id = " + carId;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				newCar.setCarMake(rs.getString(3));
				newCar.setCarModel(rs.getString(4));
				newCar.setCarYear(rs.getInt(5));
				newCar.setTotalCarPrice(rs.getDouble(6));		
			}
			
		} catch(SQLException e) {
		  
		}
		
		return newCar;
	
	}

	@Override
	public List<Car> getCarsByCustomerId(int customerId) {
		List<Car> customersOwnedCars = new ArrayList<Car>();

		String sql = "select * from car where customer_id = " + customerId;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //Loops through every row 
				customersOwnedCars.add(new Car(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6))); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customersOwnedCars;
	}
	
	

}
