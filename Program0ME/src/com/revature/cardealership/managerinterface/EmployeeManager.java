package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Offer;

public interface EmployeeManager {
	public Offer acceptOffer(Car car);
	public void addCar(CarLot carLot, Car car);
	public void removeCar(CarLot carLot, Car car);
}
