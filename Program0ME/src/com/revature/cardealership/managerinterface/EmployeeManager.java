package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;

public interface EmployeeManager {
	public Offer acceptOffer(int index, Inventory inventory);
	public Offer rejectOffer(Car car);
	public void addCar(CarLot carLot, String make, String model);
	public void removeCar(CarLot carLot, Car car);
	public Employee createAnAccount(String userId, String password, Inventory inventory);
}
