package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;

public interface CustomerManager extends UserManager {
	public void viewAllCars(CarLot carLot);
	public void createAnOffer(Customer customer, Car car, Inventory inventory);
	public void viewOwnedCars(Customer customer);
	public void viewRemainingPayments(Customer customer, Car car);
	//public void makeAMonthlyPayment();
}
