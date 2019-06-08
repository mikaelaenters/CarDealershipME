package com.revature.cardealership.managerimpl;

import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.managerinterface.UserManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.User;

public class CustomerManagerImpl implements CustomerManager, UserManager {

	@Override
	public void viewAllCars(CarLot carLot) {
		for(Car car : carLot.getCarLot()) {
			System.out.println(car.toString());
		}
	}

	@Override
	public void createAnOffer(Customer customer, Car car, double offerAmount, Inventory inventory) {
		// TODO MAP CAR TO LIST OFF OFFERS ON IT. THEN ITTER OVER USING ENTRY MAP THING
		//first check if customer has already made this off if so let them know
		//if not let them create.
		//add to map
		
		Offer newOffer = new Offer(customer, car, offerAmount);
		car.getCarOffers().add(newOffer);
		inventory.getCurrentCarOffers().put(car, car.getCarOffers());
		
	}

	@Override
	public void viewOwnedCars(Customer customer) {
		for(Car car : customer.getOwnedCars()) {
			System.out.println(car.toString());
		}
	}

	@Override
	public void viewRemainingPayments(Customer customer, Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAnAccount(String firstName, String lastName, String userId, String password) {
		Customer newCustomer = new Customer(firstName, lastName, userId, password);
		//TODO 
		//Add to list of Accounts in System
		

	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		
	}

}
