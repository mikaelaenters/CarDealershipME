package com.revature.cardealership.utilities;

public class WelcomeScreen implements PromptScreen {

	public static final String WELCOME_MESSAGE = "----------Welcome to Mikaela's Monster Car Shop!----------\n"
			+ "*****All cars come in uniquely designed monster forms*****\n";
	@Override
	public void display() {
		System.out.println(WELCOME_MESSAGE);

	}

}
