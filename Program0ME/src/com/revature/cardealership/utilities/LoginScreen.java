package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.CarDealership;

public class LoginScreen implements Screen {

	public static final String LOGIN_MESSAGE = "Do you want to login as a Customer or Employee?\n"
			+ "Enter 1 for Customer\nEnter 2 for Employee";
	@Override
	public void display(CarDealership carDealership) {
		System.out.println(LOGIN_MESSAGE);

	}

}
