package com.revature.cardealership.utilities;

import com.revature.cardealership.daos.CustomerDAO;
import com.revature.cardealership.daos.CustomerDAOPostgresImpl;
import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Customer;

public class CustomerScreen implements CScreen {
	
	private static  CustomerManager cManager = new CustomerManagerImpl();
	private static PromptScreen customerMenuScreen = new CustomerMenu();
	private static CustomerMenuManager cOptions = new CustomerMenuOptions();
	private static CustomerDAO customerdao = new CustomerDAOPostgresImpl();
	
	private String username,
	               password;
	private boolean valid;
	
	@Override
	public Customer display() {
		do {
			System.out.println("Do you want to LOGIN or CREATE An Account?\nEnter"
					+ " 1 to LOGIN\nEnter 2 to CREATE An Account");
			int loginOption = UserInputUtility.getNumber(1, 2);
			
			switch(loginOption) {
				case 1: System.out.println("-------CUSTOMER LOGIN-------\nPlease Enter "
						+ "Your Username: ");
						username = UserInputUtility.getAccountInfo();
						System.out.println("Please Enter Your Password: ");
						password = UserInputUtility.getAccountInfo();
						
					    valid = customerdao.customerValidation(username, password);
						
						if(!valid) {
							//System.out.println("Incorrect Username Or Password. Try Again Or Create An Account.");
							LoggingUtility.warn("Incorrect Username Or Password. Try Again Or Create An Account.");
						}
						else {
							LoggingUtility.trace("Successful Login");
						}
						break;
						
				case 2:System.out.println("-------CREATE A CUSTOMER ACCOUNT-------\nPlease Enter "
						+ "Your Username: ");
						username = UserInputUtility.getAccountInfo();
						System.out.println("Please Enter Your Password: ");
						password = UserInputUtility.getAccountInfo();
						cManager.createAnAccount(username, password);	
						LoggingUtility.trace("Your Account Has Been Created.");	
						valid = true;
			}

			}while(!valid);
		
		return new Customer(username, password);
	
	}
	
	
	@Override
	public int menuOptions(Customer customer) {
		
		customerMenuScreen.display();
		int customerOption = UserInputUtility.menuValidation(1, 6);
		
		switch(customerOption) {
		case 1: cOptions.option1();
			break;
		case 2:	cOptions.option2(customer);
			break;
		case 3: cOptions.option3(customer);
			break;
		case 4: cOptions.option4(customer);
			break;
		case 5: cOptions.option5(customer);
			break;
		}

		return customerOption;
		
	}

}
