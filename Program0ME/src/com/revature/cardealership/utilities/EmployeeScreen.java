package com.revature.cardealership.utilities;

import com.revature.cardealership.managerimpl.EmployeeManagerImpl;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public class EmployeeScreen implements EScreen {
	private static LoginValidation validLogin = new LoginValidationImpl();
	private static  EmployeeManager eManager = new EmployeeManagerImpl();
	private static PromptScreen employeeMenuScreen = new EmployeeMenu();
	private static EmployeeMenuManager eOptions = new EmployeeMenuOptions();
	private String userName,
	   password;
	public int employeeIndex;
	
	@Override
	public Employee display(Inventory inventory) {
		
	
			do {
				System.out.println("Do you want to LOGIN or CREATE An Account?\nEnter"
						+ " 1 to LOGIN\nEnter 2 to CREATE An Account");
				int loginOption = UserInputUtility.getNumber(1, 2);
				
				switch(loginOption) {
					case 1: System.out.println("-------EMPLOYEE LOGIN-------\nPlease Enter "
							+ "Your Username: ");
							userName = UserInputUtility.getAccountInfo();
							System.out.println("Please Enter Your Password: ");
							password = UserInputUtility.getAccountInfo();
							
							employeeIndex = validLogin.userValidation(inventory, 2, userName, password);
							
							if(employeeIndex == -1) {
								//System.out.println("Incorrect Username Or Password. Try Again Or Create An Account.");
								LoggingUtility.warn("Incorrect Username Or Password. Try Again Or Create An Account.");
							}
							else {
								LoggingUtility.trace("Successful Login");
							}	
							break;
							
					case 2:System.out.println("-------CREATE A EMPLOYEE ACCOUNT-------\nPlease Enter "
							+ "Your Username: ");
							userName = UserInputUtility.getAccountInfo();
							System.out.println("Please Enter Your Password: ");
							password = UserInputUtility.getAccountInfo();
							LoggingUtility.trace("Your Account Has Been Created.");
							return eManager.createAnAccount(userName, password, inventory);
									
				}

				}while(employeeIndex == -1);
			
			return inventory.getEmployeeList().get(employeeIndex);
	}

	@Override
	public int menuOptions(Inventory inventory, CarLot carLot, Employee employee) {
		employeeMenuScreen.display(inventory);
		
		int employeeOption = UserInputUtility.menuValidation(1, 6);
		
		switch(employeeOption) {
		case 1: eOptions.option1(inventory);
			break;
		case 2:	eOptions.option2(inventory);
			break;
		case 3: eOptions.option3(carLot);
			break;
		case 4: eOptions.option4(carLot); 
			break;
		case 5: eOptions.option5(inventory);
			break;
		}
		
		
		return employeeOption;
		
		
	}

}
