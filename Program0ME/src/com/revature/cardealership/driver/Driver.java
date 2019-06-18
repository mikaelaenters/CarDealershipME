package com.revature.cardealership.driver;

import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.utilities.CScreen;
import com.revature.cardealership.utilities.CustomerScreen;
import com.revature.cardealership.utilities.EScreen;
import com.revature.cardealership.utilities.EmployeeScreen;
import com.revature.cardealership.utilities.LoggingUtility;
import com.revature.cardealership.utilities.LoginScreen;
import com.revature.cardealership.utilities.UserInputUtility;
import com.revature.cardealership.utilities.WelcomeScreen;

public class Driver {

	
	private static WelcomeScreen welcome = new WelcomeScreen();
	private static LoginScreen login = new LoginScreen();
	private static CScreen customerScreen = new CustomerScreen();
	private static EScreen employeeScreen = new EmployeeScreen();
	
	public static void main(String[] args) { 
	
	int input;	
			welcome.display();
			login.display();

			int loginOption = UserInputUtility.getNumber(1, 2);

			
			if(loginOption == 1) {
				Customer customer = customerScreen.display();
				System.out.println("Thank You for Logging In!\n");
			//	LoggingUtility.trace("Thank you for Logging In!\n");
				do {
					input = customerScreen.menuOptions(customer);
				}while(input != 6);
				
				//System.out.println("Logging Out... ");
				LoggingUtility.trace("Logging Out...");
	
				System.exit(0);
			}
		
			else if(loginOption == 2) {
				Employee employee = employeeScreen.display(); 
			//System.out.println("Thank You for Logging In!\n");
			LoggingUtility.trace("Thank you for Logging In!\n");
				do {
				input = employeeScreen.menuOptions();
			}while(input != 6);
				
			//System.out.println("Logging Out...");
				LoggingUtility.trace("Logging Out...");

				System.exit(0);	
		}
			
		
	}

		
}
