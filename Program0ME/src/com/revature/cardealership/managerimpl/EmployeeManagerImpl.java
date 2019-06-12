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
			
//			if(inventory.getCurrentCarsWithOffers().get(index).getCarOffers().size() == 1) {                     //If there is only one offer on the car
//				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setAccepted(true);
//				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setPending(false);
//			}
//			else {
				for(int i = 1; i < inventory.getCurrentCarsWithOffers().get(index).getCarOffers().size(); i++) {
					if(inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).getOfferAmount() < inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).getOfferAmount()) {
						inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setPending(false);
						inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setRejected(true);
						highest = i;
						
					}
				}
				
				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setAccepted(true);            //Accept the highest offer
				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setPending(false);
				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest).setRejected(false);
		//	}
			
		//	rejectAllPending(car); //Rejects all remaining offers in the system.
		//	removeOffers(index, inventory);
			return inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(highest);
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
	public void removeCar(CarLot carLot, Car car) {
		carLot.removeCarFromLot(car);
	}


	@Override
	public Employee createAnAccount(String userId, String password, Inventory inventory) {
		Employee newEmployee = new Employee(userId, password);
		inventory.getEmployeeList().add(newEmployee);
		return newEmployee;
		
		

	}
//	
//	public static void rejectAllPending(int index, Inventory inventory) {
//		
//		for(int i = 0; i < inventory.getCurrentCarsWithOffers().get(index).getCarOffers().size(); i++) {
//			if(inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(i).isPending() == true) {
//				inventory.getCurrentCarsWithOffers().get(index).getCarOffers().get(i).setPending(false);
//			}
//		}
//		
//		for(int i = 0; i < car.getCarOffers().size(); i++) {
//			if(car.getCarOffers().get(i).isPending() == true) {
//				car.getCarOffers().get(i).setPending(false);
//			}
//		}
//
//	}
	
//	public static void removeOffers(int index, Inventory inventory) {
//		inventory.getCurrentCarsWithOffers().remove(index);
//	}


}
