package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;

public interface CustomerManager {
	public void viewAllCars(CarLot carLot);
	public void createAnOffer(Customer customer, Car car, double offerAmount);
	public void viewOwnedCars(Customer customer);
	public void viewRemainingPayments(Customer customer, Car car);
	//public void createAnAccount(String firstName, String lastName, String userId, String password);
	//public void makeAMonthlyPayment();
}
