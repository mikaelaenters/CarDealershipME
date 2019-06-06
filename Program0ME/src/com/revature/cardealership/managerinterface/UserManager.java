package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.User;

public interface UserManager {
	
	public void createAnAccount(String firstName, String lastName, String userId, String password);
	public void login(User user);
}
