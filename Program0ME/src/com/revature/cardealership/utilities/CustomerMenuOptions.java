package com.revature.cardealership.utilities;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;

public class CustomerMenuOptions {
	
	private static CustomerManager customerManager = new CustomerManagerImpl();
	public void option1(CarLot carLot) {
		System.out.println("Here Are All the Current Cars on the Lot:");
		customerManager.viewAllCars(carLot);
	}
	
	public void option2(Customer customer, CarLot carLot, Inventory inventory) {
		int i = 0;
			System.out.println("What Car Would You Like to OFFER On?");
			try {
				for(Car car : carLot.getCarLot()) {
					System.out.println("Car ID = " + i);
					System.out.println(car.toString());
					i++;
				}
				if(carLot.getCarLot().size() == 0) {
					System.out.println("Sorry there are no cars in the lot");
				}
				else {
					int index = UserInputUtility.validationPrompt(0, carLot.getCarLot().size()-1);
					customerManager.createAnOffer(customer, carLot.getCarLot().get(index), inventory);
				}
			}catch(NullPointerException e) {
				//System.out.println("Sorry there are no cars in the lot");
			}
	}
	
	public void option3(Customer customer) {
		customerManager.viewOwnedCars(customer);
	}
}
