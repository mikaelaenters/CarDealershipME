package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Inventory;

public class WelcomeScreen implements PromptScreen {

	public static final String WELCOME_MESSAGE = "Welcome to Mikaela's Used Cars!";
	@Override
	public void display(Inventory inventory) {
		System.out.println(WELCOME_MESSAGE);

	}

}
