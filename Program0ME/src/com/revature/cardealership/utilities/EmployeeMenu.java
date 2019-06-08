package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Inventory;

public class EmployeeMenu implements PromptScreen {
	private static final String E_MENU = "----------Employee Menu-----------\n"
			          + "Enter 1 to ACCEPT offer on a car\nEnter 2 to REJECT offer on a car\n"
			          + "Enter 3 to ADD a New Car\nEnter 4 to REMOVE a car\nEnter 5 to VIEW All Payments";
	@Override
	public void display(Inventory inventory) {
		System.out.println(E_MENU);
		
	}

}
