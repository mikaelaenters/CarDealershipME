package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public class LoginValidationImpl {

	public String userIdValidation(User user, Inventory inventory, int index) {
		String userId = UserInputUtility.retrieveUserId();
		boolean isValid;
			if(index == 1) {
				isValid = true;
				
				for(int i = 0; i < inventory.getCustomerList().size(); i++) {
					if(!inventory.getCustomerList().get(i).getUserId().equals(userId)) {
						isValid = false;
						System.out.println("Incorrect Username! Try Again Or Create An Accout.");
						break;
					}
					
				if(!isValid) {
					//CREATE ACCOUNT OR LOGIN? DO WHILE.
				}
			}
	}
}
