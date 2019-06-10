package com.revature.cardealership.driver;

import com.revature.cardealership.daos.InventoryDAO;
import com.revature.cardealership.daos.InventorySerializeDAO;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Inventory;
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
	
	private static InventoryDAO idao = new InventorySerializeDAO();
	
	public static void main(String[] args) { 	
		Inventory inventory;
		
		if(idao.loadInventory() == null) {
			inventory = new Inventory();
		}
		else {
			inventory = idao.loadInventory();
		}
			
			CarLot carLot = inventory.getCarLot();
			Customer customer;
			Employee employee;
			int input;	
			
			welcome.display(inventory);
			
			login.display(inventory);
			
			int loginOption = UserInputUtility.getNumber(1, 2);
			
			
			if(loginOption == 1) {
				customer = customerScreen.display(inventory);
				//System.out.println("Thank You for Logging In!\n");
				LoggingUtility.trace("Thank you for Logging In!\n");
				do {
					input = customerScreen.menuOptions(inventory, carLot, customer);
				}while(input != 6);
				
				//System.out.println("Logging Out... ");
				LoggingUtility.trace("Logging Out...");
				idao.saveInventory(inventory);
				System.exit(0);
			}
		
			else if(loginOption == 2) {
				employee = employeeScreen.display(inventory); 
				//System.out.println("Thank You for Logging In!\n");
				LoggingUtility.trace("Thank you for Logging In!\n");
				do {
					input = employeeScreen.menuOptions(inventory, carLot, employee);
				}while(input != 6);
				
				//System.out.println("Logging Out...");
				LoggingUtility.trace("Logging Out...");
				idao.saveInventory(inventory);
				System.exit(0);	
			}
			
		
		}
		
		
}
