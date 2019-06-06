package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.CarDealership;

public class WelcomeScreen implements Screen {

	public static final String WELCOME_MESSAGE = "Welcome to " + CarDealership.getDealershipName() + "!";
	@Override
	public void display(CarDealership carDealership) {
		System.out.println(WELCOME_MESSAGE);

	}

}
