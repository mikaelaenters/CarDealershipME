package com.revature.cardealership.driver;

import com.revature.cardealership.pojo.CarDealership;
import com.revature.cardealership.utilities.LoginScreen;
import com.revature.cardealership.utilities.UserInputUtility;
import com.revature.cardealership.utilities.WelcomeScreen;

public class Driver {

	
	private static WelcomeScreen welcome = new WelcomeScreen();
	private static LoginScreen login = new LoginScreen();
	
	public static void main(String[] args) {
		CarDealership carDealership = null; 
		welcome.display(carDealership);
		login.display(carDealership);
		int loginOption = UserInputUtility.getNumber(1, 2);
		System.out.println("YAY");

	}

}
