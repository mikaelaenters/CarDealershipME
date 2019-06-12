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
			
				for(int i = 0; i < car.getCarOffers().size(); i++) {
					if(car.getCarOffers().get(i).getOfferAmount() >= offerAmount) {
						System.out.println("There is currently a higher offer.\n"
								+ "Please Create An Offer Higher Than $"
								+ car.getCarOffers().get(i).getOfferAmount());
						validOfferAmount = false;
						break;
						
					}
				}
				
			}while(!validOfferAmount);
			
			//Add Car to CarOffers List
			inventory.getCurrentCarsWithOffers().add(car);
			
			return new Offer(customer, car, offerAmount);
		
			
		
	}

	@Override
	public void viewOwnedCars(Customer customer) {
		if(customer.getOwnedCars().size() == 0) {
			System.out.println("You Don't Own Any Cars!");
		}
		else {
			for(Car car : customer.getOwnedCars()) {
				System.out.println(car.toString() + " [monthlyPayment= " + car.getMonthlyPayment() + ", totalAmountOwed= " + car.getTotalCarPrice() +"]");
			}
		}
	}

	@Override
	public void viewRemainingPayments(Customer customer, Car car) {
		if(customer.getNumberOfPayments() == 0) {
			System.out.println("You Haven't Made Any Payments Yet!");
		}
		else {
			System.out.println("You Have Made " + customer.getNumberOfPayments() + " Payment(s) on " + car.toString() 
			+ " [monthlyPayment= " + car.getMonthlyPayment() + ", "
			+ "totalAmountOwed= " + car.getTotalCarPrice() +"]");
		}
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
		//customer.setTotalCarPrice(customer.getTotalCarPrice()-customer.getMonthlyPayment());
		customer.getOwnedCars().get(carIndex).setTotalCarPrice(customer.getOwnedCars().get(carIndex).getTotalCarPrice() -customer.getOwnedCars().get(carIndex).getMonthlyPayment());
		System.out.println("[monthlyPayment= " + customer.getOwnedCars().get(carIndex).getMonthlyPayment() + ", totalAmountOwed= " + customer.getOwnedCars().get(carIndex).getTotalCarPrice() +"]");
		inventory.getAllPayments().add(new Payment(customer, customer.getOwnedCars().get(carIndex).getMonthlyPayment(), customer.getOwnedCars().get(carIndex)));	
	}
	


}
