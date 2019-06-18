package com.revature.cardealership.utilities;

public class CustomerMenu implements PromptScreen {
	private static final String C_MENU = "---------------Customer Menu----------------\n"
	          + "Enter 1 to VIEW all cars on the lot\nEnter 2 to CREATE an offer on a car\n"
	          + "Enter 3 to VIEW your owned cars\nEnter 4 to MAKE A Monthly Payment\nEnter 5 to VIEW Remaining Payments"
	          + "\nEnter 6 to LogOut";
	@Override
	public void display() {
		System.out.println(C_MENU);

	}

}
