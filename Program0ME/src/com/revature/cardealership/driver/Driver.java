package com.revature.cardealership.driver;

import com.revature.cardealership.pojo.CarDealership;
import com.revature.cardealership.pojo.CarLot;
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
		CarDealership carDealership = new CarDealership(); 
		Inventory inventory = new Inventory();
		CarLot carLot = new CarLot();
		welcome.display(carDealership);
		login.display(carDealership);
		int loginOption = UserInputUtility.getNumber(1, 2);
		
		if(loginOption == 2) {
			int employeeOption;
			do {
				employeeMenu.display(carDealership);
				//Actually login here....
				employeeOption = UserInputUtility.employeeMenu(1, 6);
				switch(employeeOption) {
				case 1: eManager.option1(inventory);
					break;
				case 2: eManager.option2(inventory);
					break;
				case 3: eManager.option3(carLot);
					break;
				case 4: eManager.option4(carLot);
					break;
				case 5: break;
				case 6: System.out.println("Logging Out...");
					break;
				}
			}while(employeeOption != 6);

		}
	}

}
