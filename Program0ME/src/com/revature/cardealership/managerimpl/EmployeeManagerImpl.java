package com.revature.cardealership.managerimpl;

import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.Offer;

public class EmployeeManagerImpl implements EmployeeManager {
	@Override
	public Offer acceptOffer(int index, Inventory inventory) {
		int highest = 0;
	
				for(int i = 1; i < inventory.getCurrentCarsWithOffers().get(index).getCarOffers().size(); i++) {
					if(inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).getOfferAmount() < inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(i).getOfferAmount()) {
						inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setPending(false);
						inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setRejected(true);
						highest = i;
						
					}
				}
				
				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setAccepted(true);            //Accept the highest offer
				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setPending(false);
				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setRejected(false);
	
			return inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest);
	}


	@Override
	public Offer rejectOffer(int index, Inventory inventory) {
		int lowest = 0;
		

		for(int i = 1; i < inventory.getCurrentCarsWithOffers().get(index).getCarOffers().size(); i++) {
			if(inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(lowest).getOfferAmount() > inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(i).getOfferAmount()) {
				lowest = i;
			}
		}
		
			inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(lowest).setAccepted(false);            //Reject the Lowest offer
			inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(lowest).setPending(false);
			inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(lowest).setRejected(true);

		return inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(lowest);
	}
	
	@Override
	public void addCar(CarLot carLot, String make, String model) {
		carLot.addCarToLot(make, model);
	}

	@Override
	public void removeCar(CarLot carLot, Car car) {
		carLot.removeCarFromLot(car);
	}


	@Override
	public Employee createAnAccount(String userId, String password, Inventory inventory) {
		Employee newEmployee = new Employee(userId, password);
		inventory.getEmployeeList().add(newEmployee);
		return newEmployee;
		
		

	}

}
