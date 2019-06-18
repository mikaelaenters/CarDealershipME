package com.revature.cardealership.utilities;

import com.revature.cardealership.daos.EmployeeDAO;
import com.revature.cardealership.daos.EmployeeDAOPostgresImpl;
import com.revature.cardealership.managerimpl.EmployeeManagerImpl;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Employee;

public class EmployeeScreen implements EScreen {
	
	private static  EmployeeManager eManager = new EmployeeManagerImpl();
	private static PromptScreen employeeMenuScreen = new EmployeeMenu();
	private static EmployeeMenuManager eOptions = new EmployeeMenuOptions();
	private static EmployeeDAO employeedao = new EmployeeDAOPostgresImpl();
	
	private String username,
	   			   password;
	private boolean valid;
	
	@Override
	public Employee display() {
		
	
			do {
				System.out.println("Do you want to LOGIN or CREATE An Account?\nEnter"
						+ " 1 to LOGIN\nEnter 2 to CREATE An Account");
				int loginOption = UserInputUtility.getNumber(1, 2);
				
				switch(loginOption) {
					case 1: System.out.println("-------EMPLOYEE LOGIN-------\nPlease Enter "
							+ "Your Username: ");
							username = UserInputUtility.getAccountInfo();
							System.out.println("Please Enter Your Password: ");
							password = UserInputUtility.getAccountInfo();
							
						    valid = employeedao.employeeValidation(username, password);
							
							if(!valid) {
								//System.out.println("Incorrect Username Or Password. Try Again Or Create An Account.");
								LoggingUtility.warn("Incorrect Username Or Password. Try Again Or Create An Account.");
							}
							else {
								LoggingUtility.trace("Successful Login");
							}
							break;
							
					case 2:System.out.println("-------CREATE A EMPLOYEE ACCOUNT-------\nPlease Enter "
							+ "Your Username: ");
							username = UserInputUtility.getAccountInfo();
							System.out.println("Please Enter Your Password: ");
							password = UserInputUtility.getAccountInfo();
							eManager.createAnAccount(username, password);		
							LoggingUtility.trace("Your Account Has Been Created.");	
							valid = true;
				}

				}while(!valid);
			
			return new Employee(username, password);
	}

	@Override
	public int menuOptions() {
		employeeMenuScreen.display();
		
		int employeeOption = UserInputUtility.menuValidation(1, 6);
		
		switch(employeeOption) {
		case 1: eOptions.option1();
			break;
		case 2:	eOptions.option2();
			break;
		case 3: eOptions.option3();
			break;
		case 4: eOptions.option4(); 
			break;
		case 5: eOptions.option5();
			break;
		}
	
		return employeeOption;	
	}

}
