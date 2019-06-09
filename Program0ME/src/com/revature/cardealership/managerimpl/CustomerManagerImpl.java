package com.revature.cardealership.managerimpl;

import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.Payment;
import com.revature.cardealership.utilities.UserInputUtility;

public class CustomerManagerImpl implements CustomerManager {

	@Override
	public void viewAllCars(CarLot carLot) {
		for(Car car : carLot.getCarLot()) {
			System.out.println(car.toString());
		}
	}

	@Override
	public Offer createAnOffer(Customer customer, Car car, Inventory inventory) {
		
		double offerAmount;
		boolean validOfferAmount;
			
			do {
				offerAmount = UserInputUtility.offerAmount();
				validOfferAmount = true;
				
					for(int i = 0; i < inventory.getCurrentCarOffers().size(); i++) {
						if(inventory.getCurrentCarOffers().get(car).get(i).getOfferAmount() >= offerAmount) {
							System.out.println("There is currently a higher offer.\n"
									+ "Please Create An Offer Higher Than $"
									+ inventory.getCurrentCarOffers().get(car).get(i).getOfferAmount());
							validOfferAmount = false;
							break;
						}
					}
			}while(!validOfferAmount);
			
			Offer newOffer = new Offer(customer, car, offerAmount);
			return newOffer;
			
		
	}

	@Override
	public void viewOwnedCars(Customer customer) {
		if(customer.getOwnedCars() == null) {
			System.out.println("You Don't Own Any Cars!");
		}
		else {
			for(Car car : customer.getOwnedCars()) {
				System.out.println(car.toString() + " [monthlyPayment= " + customer.getMonthlyPayment() + ", totalAmountOwed= " + customer.getTotalCarPrice() +"]");
			}
		}
	}

	@Override
	public void viewRemainingPayments(Customer customer, Car car) {
		System.out.println("You Have Made " + customer.getNumberOfPayments() + "on " + car.toString() 
		+ " [monthlyPayment= " + customer.getMonthlyPayment() + ", "
		+ "totalAmountOwed= " + customer.getTotalCarPrice() +"]");

	}

	@Override
	public Customer createAnAccount(String userId, String password, Inventory inventory) {
		Customer newCustomer = new Customer(userId, password);
		inventory.getCustomerList().add(newCustomer);
		return newCustomer;
	}

	@Override
	public double calculateMonthlyPayment(double totalPrice) {
		return totalPrice/12;
		
	}

	@Override
	public void makeAMonthlyPayment(Customer customer, int carIndex, Inventory inventory) {
		customer.setTotalCarPrice(customer.getTotalCarPrice()-customer.getMonthlyPayment());
		System.out.println("[monthlyPayment= " + customer.getMonthlyPayment() + ", totalAmountOwed= " + customer.getTotalCarPrice() +"]");
		inventory.getAllPayments().add(new Payment(customer, customer.getMonthlyPayment(), customer.getOwnedCars().get(carIndex)));
	}
	
	
	


}
