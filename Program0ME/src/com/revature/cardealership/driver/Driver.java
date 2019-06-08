package com.revature.cardealership.driver;

import com.revature.cardealership.pojo.CarDealership;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.utilities.EmployeeMenu;
import com.revature.cardealership.utilities.EmployeeMenuManager;
import com.revature.cardealership.utilities.EmployeeMenuOptions;
import com.revature.cardealership.utilities.LoginScreen;
import com.revature.cardealership.utilities.UserInputUtility;
import com.revature.cardealership.utilities.WelcomeScreen;

public class Driver {

	
	private static WelcomeScreen welcome = new WelcomeScreen();
	private static LoginScreen login = new LoginScreen();
	private static EmployeeMenu employeeMenu = new EmployeeMenu();
	private static EmployeeMenuManager eManager = new EmployeeMenuOptions();
	
	public static void main(String[] args) {
		CarDealership carDealership = null; 
		Inventory inventory = null;
		welcome.display(carDealership);
		login.display(carDealership);
		int loginOption = UserInputUtility.getNumber(1, 2);
		
		if(loginOption == 2) {
		employeeMenu.display(carDealership);
		//Actually login here....
		int employeeOption = UserInputUtility.employeeMenu(1, 3);
		switch(employeeOption) {
		case 1: eManager.option1(inventory);
			break;
		case 2:System.out.println("Option 2");
			break;
		case 3:System.out.println("Option 3");
			break;
		}
		}

	}

}
