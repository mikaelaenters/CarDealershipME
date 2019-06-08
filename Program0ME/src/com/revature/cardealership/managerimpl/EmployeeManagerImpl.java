package com.revature.cardealership.managerimpl;

import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.managerinterface.UserManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Offer;
import com.revature.cardealership.pojo.User;

public class EmployeeManagerImpl implements EmployeeManager, UserManager {
	@Override
	public Offer acceptOffer(Car car) {
		int highest = 0;
			
			if(car.getCarOffers().size() == 1) {                     //If there is only one offer on the car
				car.getCarOffers().get(highest).setAccepted(true);
				car.getCarOffers().get(highest).setPending(false);	
			}
			else {
				for(int i = 1; i < car.getCarOffers().size(); i++) {
					if(car.getCarOffers().get(highest).getOfferAmount() < car.getCarOffers().get(i).getOfferAmount()) {
						highest = i;
					}
				}
				
				car.getCarOffers().get(highest).setAccepted(true);              //Accept the highest offer 
				car.getCarOffers().get(highest).setPending(false);
			}
			
			return car.getCarOffers().get(highest);
	}


	@Override
	public Offer rejectOffer(Car car) {
		int lowest = 0;
		
		if(car.getCarOffers().size() == 1) {                     //If there is only one offer on the car
			car.getCarOffers().get(lowest).setRejected(true);
			car.getCarOffers().get(lowest).setPending(false);	
		}
		else {
			for(int i = 1; i < car.getCarOffers().size(); i++) {
				if(car.getCarOffers().get(lowest).getOfferAmount() > car.getCarOffers().get(i).getOfferAmount()) {
					lowest = i;
				}
			}
			
			car.getCarOffers().get(lowest).setRejected(true);              //Reject the Lowest offer 
			car.getCarOffers().get(lowest).setPending(false);
		}
		
		return car.getCarOffers().get(lowest);
	}
	
	@Override
	public void addCar(CarLot carLot, String make, String model) {
		carLot.addCarToLot(make, model);
	}

	@Override
	public void removeCar(CarLot carLot, int index) {
		carLot.removeCarFromLot(index);
	}


	@Override
	public void createAnAccount(String firstName, String lastName, String userId, String password) {
		Employee newEmployee = new Employee(firstName, lastName, userId, password);
		
		

	}


	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		
	}


}
