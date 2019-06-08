package com.revature.cardealership.utilities;

import com.revature.cardealership.managerimpl.CustomerManagerImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public class LoginValidationImpl implements LoginValidation{
	
	@Override
	public int userValidation(Inventory inventory, int index, String userName, String password) {
		int userIndex = -1;
		
		if(index == 1) {
			for(int i = 0; i < inventory.getCustomerList().size(); i++) {
				if(inventory.getCustomerList().get(i).getUserId().equals(userName) && inventory.getCustomerList().get(i).getPassword().equals(password)) {
					return i;
					}
				}
			return userIndex;
			
		}
			
		else {
			for(int i = 0; i < inventory.getEmployeeList().size(); i++) {
				if(inventory.getEmployeeList().get(i).getUserId().equals(userName) && inventory.getEmployeeList().get(i).getPassword().equals(password)) {
					return i;
					}
				}
			return userIndex;
		}
	}
	
}
