package com.revature.cardealership.utilities;

import java.util.ArrayList;
import java.util.List;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerimpl.EmployeeManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.Payment;

public class EmployeeMenuOptions implements EmployeeMenuManager {

	private static EmployeeManager employeeManager = new EmployeeManagerImpl(); 
	private static CustomerManager customerManager = new CustomerManagerImpl();
	
	public void option1(Inventory inventory) {
		
		int i = 0;
		List<Car> tempList = new ArrayList<Car>();
			
			if(inventory.getCurrentCarOffers().size() == 0) {
				System.out.println("Sorry There Are NO CURRENT OFFERS To Accept!");
			}
			else {
				System.out.println("What CAR would you like to ACCEPT an offer on?");
				for(Car car : inventory.getCurrentCarOffers().keySet()) {
					tempList.add(car);
					System.out.println("Car ID = " + i);
					System.out.println(car.toString());
					i++;
				}
				int index = UserInputUtility.validationPrompt(0, tempList.size() - 1);
				Offer acceptedOffer = employeeManager.acceptOffer(tempList.get(index), inventory);
				
				Customer customer = acceptedOffer.getCustomer();
				Car currentCar = tempList.get(index);
				
				inventory.getCustomerList().get(customer.getCustomerIndex()-1).getOwnedCars().add(currentCar);
				
				customer.setTotalCarPrice(acceptedOffer.getOfferAmount());  //Set totalCarPrice
				customer.setMonthlyPayment(customerManager.calculateMonthlyPayment(acceptedOffer.getOfferAmount())); //Sets Customer Monthly Payment
				System.out.println(employeeManager.acceptOffer(tempList.get(index),inventory).toString());
				
				//TODO Remove off lot. 
				inventory.getCarLot().removeCarFromLot(currentCar);
			}
	}
		

	public void option2(Inventory inventory) {
	 
		
		int i = 0;
		List<Car> tempList = new ArrayList<Car>();
			if(inventory.getCurrentCarOffers().size() == 0) {
				System.out.println("Sorry There Are NO CURRENT OFFERS To Reject!");
			}
			else {
				System.out.println("What CAR would you like to REJECT an offer on?");
				for(Car car : inventory.getCurrentCarOffers().keySet()) {
					tempList.add(car);
					System.out.println("Car ID = " + i);
					System.out.println(car.toString());
					i++;
				}
					
				int index = UserInputUtility.validationPrompt(0, tempList.size() - 1);
				System.out.println(employeeManager.rejectOffer(tempList.get(index)).toString());
			}
	}
	
	public void option3(CarLot carLot) {
		String carMake = UserInputUtility.makeAndModelPrompt("Make");
		String carModel = UserInputUtility.makeAndModelPrompt("Model");
		employeeManager.addCar(carLot, carMake, carModel);
		
	}
	
	public void option4(CarLot carLot) {
		int i = 0;
		if(carLot.getCarLot().size() == 0) {
			System.out.println("Sorry there are no cars in the lot");
		}
		else {
			System.out.println("What CAR would you like to REMOVE from the Car Lot?");
			
				for(Car car : carLot.getCarLot()) {
					System.out.println("Car ID = " + i);
					System.out.println(car.toString());
					i++;
				}
				
					int index = UserInputUtility.validationPrompt(0, carLot.getCarLot().size()-1);
					employeeManager.removeCar(carLot, carLot.getCarLot().get(index));
				}
			
		
	}


	@Override
	public void option5(Inventory inventory) {
		for(Payment payment : inventory.getAllPayments()) {
			System.out.println(payment.toString());
		}
		
	}

}
