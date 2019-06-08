package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.CarDealership;

public class EmployeeMenu implements Screen {
	private static final String E_MENU = "----------Employee Menu-----------\n"
			          + "Enter 1 to Accept/Reject offer on a car\nEnter 2 to ADD a "
			          + "New Car\nEnter 3 to REMOVE a car";
	@Override
	public void display(CarDealership carDealership) {
		System.out.println(E_MENU);
		
	}

}
