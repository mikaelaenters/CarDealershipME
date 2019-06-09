package com.revature.cardealership.utilities;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;

public class CustomerMenuOptions implements CustomerMenuManager {
	
	private static CustomerManager customerManager = new CustomerManagerImpl();
	
	@Override
	public void option1(CarLot carLot) {
		System.out.println("Here Are All the Current Cars on the Lot:");
		customerManager.viewAllCars(carLot);
	}
	
	@Override
	public void option2(Customer customer, CarLot carLot, Inventory inventory) {
		int i = 0;
			if(carLot.getCarLot().isEmpty()) {
				System.out.println("Sorry There Are NO CARS Currently in the Car Lot!");
			}
			else {
				System.out.println("What Car Would You Like to OFFER On?");	
				for(Car car : carLot.getCarLot()) {
					System.out.println("Car ID = " + i);
					System.out.println(car.toString());
					i++;
				}
					int index = UserInputUtility.validationPrompt(0, carLot.getCarLot().size()-1);
					
					Offer newOffer =customerManager.createAnOffer(customer, carLot.getCarLot().get(index), inventory);
					
					//carLot.getCarLot().get(index).getCarOffers().add(newOffer);
					carLot.getCarLot().get(index).addCarOfferToList(newOffer);
					inventory.getCurrentCarOffers().put(carLot.getCarLot().get(index), carLot.getCarLot().get(index).getCarOffers());
		
					System.out.println(newOffer.toString());
					
			}
	}
	
	@Override
	public void option3(Customer customer) {
		customerManager.viewOwnedCars(customer);
	}

	@Override
	public void option4(Customer customer, Inventory inventory) {
		int i = 0;
		System.out.println("What Car Would You Like to MAKE A PAYMENT On?");
		for(Car car : customer.getOwnedCars()) {
			System.out.println("Car ID = " + i);
			System.out.println(car.toString());
			i++;
		}
		
		int carIndex = UserInputUtility.validationPrompt(0, customer.getOwnedCars().size()-1);
		customerManager.makeAMonthlyPayment(customer, carIndex, inventory);
		
	}
}
