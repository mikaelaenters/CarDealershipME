package com.revature.cardealership.utilities;

import com.revature.cardealership.managerimpl.EmployeeManagerImpl;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public class EmployeeScreen implements Screen {
	private static LoginValidation validLogin = new LoginValidationImpl();
	private static  EmployeeManager eManager = new EmployeeManagerImpl();
	private String userName,
	   password;
	public int employeeIndex;
	
	@Override
	public User display(Inventory inventory) {
		
	
			do {
				System.out.println("Do you want to LOGIN or CREATE An Account?\nEnter"
						+ " 1 to LOGIN\nEnter 2 to CREATE An Account");
				int loginOption = UserInputUtility.getNumber(1, 2);
				
				switch(loginOption) {
					case 1: System.out.println("-------EMPLOYEE LOGIN-------\nPlease Enter "
							+ " Your Username: ");
							userName = UserInputUtility.getAccountInfo();
							System.out.println("Please Enter Your Password: ");
							password = UserInputUtility.getAccountInfo();
							
							employeeIndex = validLogin.userValidation(inventory, 2, userName, password);
							
							if(employeeIndex == -1) {
								System.out.println("Incorrect Username Or Password. Try Again Or Create An Accout.");
							}
							break;
							
					case 2:System.out.println("-------CREATE A EMPLOYEE ACCOUNT-------\nPlease Enter "
							+ " Your Username: ");
							userName = UserInputUtility.getAccountInfo();
							System.out.println("Please Enter Your Password: ");
							password = UserInputUtility.getAccountInfo();
					
							 return eManager.createAnAccount(userName, password);
									
				}

				}while(employeeIndex == -1);
			
			return inventory.getEmployeeList().get(employeeIndex);
	}

}
