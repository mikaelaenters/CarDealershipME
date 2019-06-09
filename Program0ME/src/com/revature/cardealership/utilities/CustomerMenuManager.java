package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;

public interface CustomerMenuManager {
	public void option1(CarLot carLot);
	public void option2(Customer customer, CarLot carLot, Inventory inventory);
	public void option3(Customer customer);
	public void option4(Customer customer, Inventory inventory);
	public void option5(Customer customer);
}
