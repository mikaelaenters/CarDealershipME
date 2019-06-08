package com.revature.cardealership.driver;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.utilities.CustomerMenu;
import com.revature.cardealership.utilities.CustomerMenuManager;
import com.revature.cardealership.utilities.CustomerMenuOptions;
import com.revature.cardealership.utilities.CustomerScreen;
import com.revature.cardealership.utilities.EmployeeMenu;
import com.revature.cardealership.utilities.EmployeeMenuManager;
import com.revature.cardealership.utilities.EmployeeMenuOptions;
import com.revature.cardealership.utilities.EmployeeScreen;
import com.revature.cardealership.utilities.LoginScreen;
import com.revature.cardealership.utilities.LoginValidation;
import com.revature.cardealership.utilities.LoginValidationImpl;
import com.revature.cardealership.utilities.Screen;
import com.revature.cardealership.utilities.UserInputUtility;
import com.revature.cardealership.utilities.WelcomeScreen;

public class Driver {

	
	private static WelcomeScreen welcome = new WelcomeScreen();
	private static LoginScreen login = new LoginScreen();
	private static Screen customerScreen = new CustomerScreen();
	private static Screen employeeScreen = new EmployeeScreen();
	
	public static void main(String[] args) { 
		Inventory inventory = new Inventory();
		CarLot carLot = new CarLot();
		Customer customer;
		Employee employee;
		int input;
		
		
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
	
		else if(loginOption == 2) {
			employee = (Employee) employeeScreen.display(inventory); 
			System.out.println("Thank You for Logging In!\n");
			do {
				input = employeeScreen.menuOptions(inventory, carLot, employee);
			}while(input != 6);
			
			System.out.println("Logging Out...");
			System.exit(0);	
		}
		
	}

}
