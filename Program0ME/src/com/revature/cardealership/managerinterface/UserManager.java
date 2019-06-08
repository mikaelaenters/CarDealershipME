package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public interface UserManager {
	
	public User createAnAccount(String userId, String password, Inventory inventory);
	
}
