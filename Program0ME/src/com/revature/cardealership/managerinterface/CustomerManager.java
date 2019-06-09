package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;

public interface CustomerManager {
	public void viewAllCars(CarLot carLot);
	public Offer createAnOffer(Customer customer, Car car, Inventory inventory);
	public void viewOwnedCars(Customer customer);
	public void viewRemainingPayments(Customer customer, Car car);
	public Customer createAnAccount(String userId, String password, Inventory inventory);
	public double calculateMonthlyPayment(double totalPrice);
	public void makeAMonthlyPayment(Customer customer, int carIndex, Inventory inventory);
}
