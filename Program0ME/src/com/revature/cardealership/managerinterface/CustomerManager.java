package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;

public interface CustomerManager {
	public void viewAllCars(CarLot carLot);
	public void createAnOffer(Customer customer, Car car, double offerAmount, Inventory inventory);
	public void viewOwnedCars(Customer customer);
	public void viewRemainingPayments(Customer customer, Car car);
	//public void makeAMonthlyPayment();
}
