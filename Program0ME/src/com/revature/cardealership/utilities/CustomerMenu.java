package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.CarDealership;

public class CustomerMenu implements Screen {
	private static final String C_MENU = "----------Customer Menu-----------\n"
	          + "Enter 1 to VIEW all cars on the lot\nEnter 2 to CREATE an offer on a car\n"
	          + "Enter 3 to VIEW your owned cars\nEnter 4 Make A Monthly Payment\nEnter 5";
	@Override
	public void display(CarDealership carDealership) {
		System.out.println(C_MENU);

	}

}
