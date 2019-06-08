package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Inventory;

public class LoginScreen implements PromptScreen {

	public static final String LOGIN_MESSAGE = "Are you a CUSTOMER or an EMPLOYEE?\n"
			+ "Enter 1 for CUSTOMER\nEnter 2 for EMPLOYEE";
	@Override
	public void display(Inventory inventory) {
		System.out.println(LOGIN_MESSAGE);

	}

}
