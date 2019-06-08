package com.revature.cardealership.driver;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.utilities.CustomerMenu;
import com.revature.cardealership.utilities.CustomerMenuManager;
import com.revature.cardealership.utilities.CustomerMenuOptions;
import com.revature.cardealership.utilities.CustomerScreen;
import com.revature.cardealership.utilities.EmployeeMenu;
import com.revature.cardealership.utilities.EmployeeMenuManager;
import com.revature.cardealership.utilities.EmployeeMenuOptions;
import com.revature.cardealership.utilities.LoginScreen;
import com.revature.cardealership.utilities.LoginValidation;
import com.revature.cardealership.utilities.LoginValidationImpl;
import com.revature.cardealership.utilities.Screen;
import com.revature.cardealership.utilities.UserInputUtility;
import com.revature.cardealership.utilities.WelcomeScreen;

public class Driver {

	
	private static WelcomeScreen welcome = new WelcomeScreen();
	private static LoginScreen login = new LoginScreen();
	private static CustomerMenu customerMenu = new CustomerMenu();
	private static CustomerMenuManager cManager = new CustomerMenuOptions();
	private static EmployeeMenu employeeMenu = new EmployeeMenu();
	private static EmployeeMenuManager eManager = new EmployeeMenuOptions();
	private static LoginValidation loginValidation = new LoginValidationImpl();
	private static CustomerManager customerCreate = new CustomerManagerImpl();
	private static Screen customerScreen = new CustomerScreen();
	
	public static void main(String[] args) { 
		Inventory inventory = new Inventory();
		CarLot carLot = new CarLot();
		Customer customer;
		int input;
		int loginValue;
		
		welcome.display(inventory);
		
		login.display(inventory);
		
		int loginOption = UserInputUtility.getNumber(1, 2);
		
		
		if(loginOption == 1) {
			customer = (Customer) customerScreen.display(inventory);
			System.out.println("Thank You for Logging In!\n");
			do {
				input = customerScreen.menuOptions(inventory, carLot, customer);
			}while(input != 5);
			
			System.out.println("Logging Out... ");
			System.exit(0);
		}

//		else if(loginOption == 2) {
//			int employeeOption;
//			do {
//				employeeMenu.display(carDealership);
//				//Actually login here....
//				employeeOption = UserInputUtility.menuValidation(1, 6);
//				switch(employeeOption) {
//				case 1: eManager.option1(inventory);
//					break;
//				case 2: eManager.option2(inventory);
//					break;
//				case 3: eManager.option3(carLot);
//					break;
//				case 4: eManager.option4(carLot);
//					break;
//				case 5: break;
//				case 6: System.out.println("Logging Out...");
//					break;
//				}
//			}while(employeeOption != 6);
//
//		}
//	}
//
//}
