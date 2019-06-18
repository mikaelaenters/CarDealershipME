package com.revature.cardealership.utilities;

import com.revature.cardealership.daos.CarDAO;
import com.revature.cardealership.daos.CarDAOPostgresImpl;
import com.revature.cardealership.daos.CustomerDAO;
import com.revature.cardealership.daos.CustomerDAOPostgresImpl;
import com.revature.cardealership.daos.OfferDAO;
import com.revature.cardealership.daos.OfferDAOPostgresImpl;
import com.revature.cardealership.daos.PaymentDAO;
import com.revature.cardealership.daos.PaymentDAOPostgresImpl;
import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.Payment;

public class CustomerMenuOptions implements CustomerMenuManager {
	
	private static CustomerManager customerManager = new CustomerManagerImpl();
	private static CarDAO cardao = new CarDAOPostgresImpl();
	private static CustomerDAO customerdao = new CustomerDAOPostgresImpl();
	private static OfferDAO offerdao = new OfferDAOPostgresImpl();
	private static PaymentDAO paymentdao = new PaymentDAOPostgresImpl();
	
	@Override
	public void option1() {
		if( cardao.getAllCarsOnLot().size() == 0) {
			System.out.println("The Car Lot is Currently Empty!");
		}
		else {
			System.out.println("Here Are All the Current Cars on the Lot:");
			customerManager.viewAllCars();
		}
	}
	
	@Override
	public void option2(Customer customer) {
		
			if(cardao.getAllCarsOnLot().size() == 0) {
				System.out.println("Sorry There Are NO CARS Currently in the Car Lot!");
			}
			else {
				System.out.println("What Car Would You Like to OFFER On?");	
				for(Car car : cardao.getAllCarsOnLot()) {
					System.out.println(car.toString());
				}
		
				int carId = UserInputUtility.carIdPrompt();
				double offerAmount = UserInputUtility.offerAmount();
				offerdao.createOffer(new Offer(customerdao.getCustomerKeyByUsername(customer.getUserId()), carId, offerAmount));	
				System.out.println("Your Offer Has Been Created.\n");
				LoggingUtility.trace("Offer was created");
			}
	}
	
	@Override
	public void option3(Customer customer) {
		customerManager.viewOwnedCars(customer);
	}

	@Override
	public void option4(Customer customer) {
		
		if(cardao.getCarsByCustomerId(customerdao.getCustomerKeyByUsername(customer.getUserId())).size() == 0 ) {
			System.out.println("You Don't Own Any Cars Yet!");
		}
		
		else {
			System.out.println("What Car Would You Like to MAKE A PAYMENT On?");
			for(Car car : cardao.getCarsByCustomerId(customerdao.getCustomerKeyByUsername(customer.getUserId()))) {
				System.out.println(car.toString());
			}
			
		int carId = UserInputUtility.carIdPrompt();
		Car customerCar = cardao.getCarById(carId);
		
		double paymentAmount = customerCar.getTotalCarPrice()/12;
		
		customerManager.makeAMonthlyPayment(paymentAmount, carId);
		System.out.println("Your Payment Has Been Processed\n");
		LoggingUtility.trace("You Made A Payment");
		}
	}

	@Override
	public void option5(Customer customer) {
		if(cardao.getCarsByCustomerId(customerdao.getCustomerKeyByUsername(customer.getUserId())).size() == 0 ) {
			System.out.println("You Don't Own Any Cars Yet!");
		}
		
		else {
			System.out.println("What Car Would You Like to VIEW PAYMENTS On?");
			for(Car car : cardao.getCarsByCustomerId(customerdao.getCustomerKeyByUsername(customer.getUserId()))) {
				System.out.println(car.toString());
			}
			
		int carId = UserInputUtility.carIdPrompt();
		Car customerCar = cardao.getCarById(carId);
		
			if(paymentdao.getPaymentsByCarId(carId).size() == 0) {
				System.out.println("You haven't made any payments yet!\n");
			}
			else {
				for(Payment p : paymentdao.getPaymentsByCarId(carId)) {
					System.out.println(p.toString());
				}
			}
		}
	}
}
