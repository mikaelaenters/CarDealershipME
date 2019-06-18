package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Customer;

public interface CustomerManager {
	
	public void viewAllCars();
	public void viewOwnedCars(Customer customer);
	public void createAnAccount(String userId, String password);
	public void makeAMonthlyPayment(double paymentAmount, int carId);
}
