package com.revature.cardealership.utilities;

import com.revature.cardealership.daos.CarDAO;
import com.revature.cardealership.daos.CarDAOPostgresImpl;
import com.revature.cardealership.daos.OfferDAO;
import com.revature.cardealership.daos.OfferDAOPostgresImpl;
import com.revature.cardealership.daos.PaymentDAO;
import com.revature.cardealership.daos.PaymentDAOPostgresImpl;
import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerimpl.EmployeeManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.Payment;

public class EmployeeMenuOptions implements EmployeeMenuManager {

	private static EmployeeManager employeeManager = new EmployeeManagerImpl(); 
	private static CustomerManager customerManager = new CustomerManagerImpl();
	private static CarDAO cardao = new CarDAOPostgresImpl();
	private static OfferDAO offerdao = new OfferDAOPostgresImpl();
	private static PaymentDAO paymentdao = new PaymentDAOPostgresImpl();
	
	public void option1() {
		if(offerdao.getAllPendingOffers().size() == 0) {
			System.out.println("Sorry There Are NO CURRENT OFFERS To Accept!");
		}
		else {
			System.out.println("What OFFER would you like to ACCEPT?");
			
			for(Offer offer : offerdao.getAllPendingOffers()) {
				System.out.println(offer.toString());		
			}

			int offerId;
			boolean validOfferId;
			
			do {	
				offerId = UserInputUtility.offerIdPrompt();       //Choose the offer to accept
				validOfferId = false;
				for(Offer offer : offerdao.getAllPendingOffers()) {
					if(offer.getOfferId() == offerId) {
						validOfferId = true; 
						break;
					}
				}
			}while(!validOfferId);
			
			Offer acceptedOffer = employeeManager.acceptOffer(offerId);
			
			if(acceptedOffer != null) {
				LoggingUtility.trace("Offer Has Been Accepted.");
				System.out.println("Offer Has Been Accepted!");
				cardao.updateCarActiveStatus(acceptedOffer.getCarId());    //Change to false to take off car lot
				cardao.updateCarOwner(acceptedOffer.getCustomerId(), acceptedOffer.getCarId());  //Give car to owner
				cardao.updateCarPrice(acceptedOffer.getCarId(), acceptedOffer.getOfferAmount());  //Set the total car price 
				
				LoggingUtility.trace("Car Has Been Removed From Car Lot.");
			}	
		}
	}
	

	public void option2() {
		
		if(offerdao.getAllPendingOffers().size() == 0) {
			System.out.println("Sorry There Are NO CURRENT OFFERS To Reject!");
		}
		else {
			System.out.println("What OFFER would you like to REJECT?");
			
			for(Offer offer : offerdao.getAllPendingOffers()) {
				System.out.println(offer.toString());		
			}

			int offerId;
			boolean validOfferId;
			
			do {	
				offerId = UserInputUtility.offerIdPrompt();       //Choose the offer to reject
				validOfferId = false;
				for(Offer offer : offerdao.getAllPendingOffers()) {
					if(offer.getOfferId() == offerId) {
						validOfferId = true; 
						break;
					}
				}
			}while(!validOfferId);
		
			Offer rejectedOffer = employeeManager.rejectOffer(offerId);
			
			if(rejectedOffer != null) {
				LoggingUtility.trace("Offer Has Been Rejected.");
				System.out.println("Offer Has Been Rejected!");
			}
		}
	}
	
	public void option3() {
		String carMake = UserInputUtility.makeAndModelPrompt("Make");
		String carModel = UserInputUtility.makeAndModelPrompt("Model");
		int carYear = UserInputUtility.getTheCarYear();
		employeeManager.addCar(carMake, carModel, carYear);
		LoggingUtility.trace("Car Has Been Added to Car Lot.");
	}
	
	public void option4() {
		if(cardao.getAllCarsOnLot().size() == 0) {
			System.out.println("Sorry there are no cars in the lot");
		}
		else {
			System.out.println("What CAR would you like to REMOVE from the Car Lot?");
			
				for(Car car : cardao.getAllCarsOnLot()) {
					System.out.println(car.toString());
				}
			
				boolean validCarId;
				int carId;
				do {	
					carId = UserInputUtility.carIdPrompt();
					validCarId = false;
					for(Car car : cardao.getAllCarsOnLot()) {
						if(car.getCarKey() == carId) {
							validCarId = true; 
							break;
						}
					}
				}while(!validCarId);
				
				employeeManager.removeCar(carId);
				LoggingUtility.trace("Car Has Been Removed From Car Lot.");
		}
	}


	@Override
	public void option5() {
		if(paymentdao.getAllPayments().size() == 0) {
			System.out.println("No payments have been made yet!");
		}
		else {
			System.out.println("Here is a List of All Payments: ");
			for(Payment p : paymentdao.getAllPayments()) {
				System.out.println(p.toString());
			}
		}
	
	}

}
