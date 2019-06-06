package com.revature.cardealership.managerimpl;

import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.managerinterface.UserManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.User;
import com.revature.cardealership.pojo.Inventory;

public class EmployeeManagerImpl implements EmployeeManager, UserManager {
	
	EmployeeManager el = new EmployeeManagerImpl();
	


	@Override
	public void acceptAndRejectOffers(Car car) {
		int highest = 0;
			
			if(car.getCarOffers() == null) {
				//TODO
				//Probably want to throw an exception here
			}
			else if(car.getCarOffers().size() == 1) {                     //If there is only one offer on the car
				car.getCarOffers().get(0).setAccepted(true);
				car.getCarOffers().get(0).setRejected(false);
				car.getCarOffers().get(0).setPending(false);	
			}
			else {
				for(int i = 1; i < car.getCarOffers().size(); i++) {
					if(car.getCarOffers().get(highest).getOfferAmount() < car.getCarOffers().get(i).getOfferAmount()) {
						
						car.getCarOffers().get(highest).setAccepted(false);            //Reject all offers that are lower &change other booleans
						car.getCarOffers().get(highest).setRejected(true);
						car.getCarOffers().get(highest).setPending(false);
						
						highest = i;
					}
				}
				
				car.getCarOffers().get(highest).setAccepted(true);              //Accept the highest offer 
				car.getCarOffers().get(highest).setRejected(false);
				car.getCarOffers().get(highest).setPending(false);
			}
	}


	@Override
	public void addCar(CarLot carLot, Car car) {
		carLot.getCarLot().add(car);

	}

	@Override
	public void removeCar(CarLot carLot, Car car) {
		carLot.getCarLot().remove(car);

	}


	@Override
	public void createAnAccount(String firstName, String lastName, String userId, String password) {
		Employee newEmployee = new Employee(firstName, lastName, userId, password);
		
		el.

	}


	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		
	}


}
