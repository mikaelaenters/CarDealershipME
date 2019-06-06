package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;

public interface EmployeeManager {
	public void acceptAndRejectOffers(Car car);
	public void addCar(CarLot carLot, Car car);
	public void removeCar(CarLot carLot, Car car);
}
