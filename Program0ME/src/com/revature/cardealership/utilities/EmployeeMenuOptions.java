package com.revature.cardealership.utilities;

import java.util.ArrayList;
import java.util.List;

import com.revature.cardealership.managerimpl.EmployeeManagerImpl;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Inventory;

public class EmployeeMenuOptions implements EmployeeMenuManager {

	private static EmployeeManager employeeManager = new EmployeeManagerImpl(); 
	
	
	public void option1(Inventory inventory) {
		//TODO Add Back Buttons!!
		int i = 0;
		List<Car> tempList = new ArrayList<Car>();
			System.out.println("What CAR would you like to ACCEPT an offer on?");
			
			try {
				for(Car car : inventory.getCurrentCarOffers().keySet()) {
					tempList.add(car);
					System.out.println("Car ID = " + i);
					System.out.println(car.toString());
					i++;
				}
				System.out.println("Please Enter the CAR ID: ");
					
				int index = UserInputUtility.validationPrompt(0, tempList.size() - 1);
				System.out.println(employeeManager.acceptOffer(tempList.get(index)).toString());
			}catch(NullPointerException e) {
				
			}
	}
		

	public void option2() {
		//same thing but with reject. 
		//TODO change accept reject method. 
	}

}
