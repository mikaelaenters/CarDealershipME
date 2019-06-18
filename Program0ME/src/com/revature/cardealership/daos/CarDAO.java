package com.revature.cardealership.daos;

import java.util.List;

import com.revature.cardealership.pojo.Car;

public interface CarDAO {
	
	public void createCar(Car car);
	public void updateCarOwner(int customerId, int carId);
	public void updateCarActiveStatus(int carId);
	public void updateCarPrice(int carId, double price);
	public List<Car> getAllCarsOnLot();
	public Car getCarById(int carId);
	public List<Car> getCarsByCustomerId(int customerId);
	
}
