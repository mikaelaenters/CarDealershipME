package com.revature.cardealership.managerimpl;

import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.managerinterface.UserManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.User;
import com.revature.cardealership.utilities.UserInputUtility;

public class CustomerManagerImpl implements CustomerManager {

	@Override
	public void viewAllCars(CarLot carLot) {
		for(Car car : carLot.getCarLot()) {
			System.out.println(car.toString());
		}
	}

	@Override
	public void createAnOffer(Customer customer, Car car, Inventory inventory) {
		
		if(inventory.getCurrentCarOffers().containsValue(customer)) {
			System.out.println("You've Already Made An Offer on THIS Car!");
		}
		else {
			double offerAmount;
			boolean validOfferAmount;
			
			do {
				offerAmount = UserInputUtility.offerAmount();
				validOfferAmount = true;
				
					for(int i = 0; i < car.getCarOffers().size(); i++) {
						if(car.getCarOffers().get(i).getOfferAmount() >= offerAmount) {
							System.out.println("There is currently a higher offer.\n"
									+ "Please Create An Offer Higher Than $"
									+ car.getCarOffers().get(i).getOfferAmount());
							validOfferAmount = false;
							break;
						}
					}
					
					if(validOfferAmount) {
						Offer newOffer = new Offer(customer, car, offerAmount);
						car.getCarOffers().add(newOffer);
						inventory.getCurrentCarOffers().put(car, car.getCarOffers());
					}
					

			}while(!validOfferAmount);
		
		}
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
