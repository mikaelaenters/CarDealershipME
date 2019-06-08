package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Inventory;

public interface LoginValidation {
	public int userValidation(Inventory inventory, int index, String userName, String password);
 
}