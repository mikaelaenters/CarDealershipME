package com.revature.cardealership.utilities;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public class CustomerScreen implements Screen {
	
	private static LoginValidation validLogin = new LoginValidationImpl();
	private static  CustomerManager cManager = new CustomerManagerImpl();
	private static PromptScreen customerMenuScreen = new CustomerMenu();
	private static CustomerMenuManager cOptions = new CustomerMenuOptions();
	
	private String userName,
		   password;
	public int customerIndex;
	
	@Override
	public User display(Inventory inventory) {
		do {
			System.out.println("Do you want to LOGIN or CREATE An Account?\nEnter"
					+ " 1 to LOGIN\nEnter 2 to CREATE An Account");
			int loginOption = UserInputUtility.getNumber(1, 2);
			
			switch(loginOption) {
				case 1: System.out.println("-------CUSTOMER LOGIN-------\nPlease Enter "
						+ " Your Username: ");
						userName = UserInputUtility.getAccountInfo();
						System.out.println("Please Enter Your Password: ");
						password = UserInputUtility.getAccountInfo();
						
						customerIndex = validLogin.userValidation(inventory, 1, userName, password);
						
						if(customerIndex == -1) {
							System.out.println("Incorrect Username Or Password. Try Again Or Create An Accout.");
						}
						break;
						
				case 2:System.out.println("-------CREATE A CUSTOMER ACCOUNT-------\nPlease Enter "
						+ " Your Username: ");
						userName = UserInputUtility.getAccountInfo();
						System.out.println("Please Enter Your Password: ");
						password = UserInputUtility.getAccountInfo();
				
						return cManager.createAnAccount(userName, password);	
			}

			}while(customerIndex == -1);
		
		return inventory.getCustomerList().get(customerIndex);
	}
	
	
	@Override
	public int menuOptions(Inventory inventory, CarLot carLot, User customer) {
		
		customerMenuScreen.display(inventory);
		
		int customerOption = UserInputUtility.menuValidation(1, 5);
		
		switch(customerOption) {
		case 1: cOptions.option1(carLot);
			break;
		case 2:	cOptions.option2((Customer)customer, carLot, inventory);
			break;
		case 3: cOptions.option3((Customer)customer);
			break;
		}
		
		
		return customerOption;
		
		
		
		
		
	}

}
