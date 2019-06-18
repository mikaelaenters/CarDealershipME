package com.revature.cardealership.managerinterface;

import java.util.List;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Offer;

public interface EmployeeManager {
	public Offer acceptOffer(int offerId);
	public Offer rejectOffer(int offerId);
	public void addCar(String carMake, String carModel, int year);
	public void removeCar(int carId);
	public void createAnAccount(String userId, String password);
}
