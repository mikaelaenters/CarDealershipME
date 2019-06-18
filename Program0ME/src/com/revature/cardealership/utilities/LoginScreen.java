package com.revature.cardealership.utilities;

public class LoginScreen implements PromptScreen {

	public static final String LOGIN_MESSAGE = "Are you a CUSTOMER or an EMPLOYEE?\n"
			+ "Enter 1 for CUSTOMER\nEnter 2 for EMPLOYEE";
	@Override
	public void display() {
		System.out.println(LOGIN_MESSAGE);

	}

}
