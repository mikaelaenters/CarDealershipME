package com.revature.cardealership.utilities;

import java.util.Scanner;

import com.revature.cardealership.pojo.Car;

public class UserInputUtility {
	
	private static final Scanner SCAN = new Scanner(System.in);
	private static boolean validInput;
	
	public static int getNumber(int min, int max) {
		int input;
		validInput = false;
			
		do {
				while(!SCAN.hasNextInt()) {
					System.out.println("Please Enter " + min + " or " + max + ": ");
					SCAN.next();
				}
				
					input = SCAN.nextInt();
					SCAN.nextLine();
				
				if (input < min || input > max) {
					System.out.println("Please Enter " + min + " or " + max + ": ");
				}
				else {
					validInput = true;
				}
		}while(!validInput);

		return input;
	}
	
	public static int employeeMenu(int min, int max) {
		int input;
		validInput = false;
			
		do {
				while(!SCAN.hasNextInt()) {
					System.out.println("Please Enter A Number Between " + min + " and " + max + ": ");
					SCAN.next();
				}
				
					input = SCAN.nextInt();
					SCAN.nextLine();
				
				if (input < min || input > max) {
					System.out.println("Please Enter A Number Between " + min + " and " + max + ": ");
				}
				else {
					validInput = true;
				}
		}while(!validInput);

		return input;
	}
	
	public static int validationPrompt(int min, int max) {
		int input;
		validInput = false;
		
		System.out.println("Please Enter the CAR ID: ");
			
		do {
				while(!SCAN.hasNextInt()) {
					System.out.println("Please Enter A Number: ");
					SCAN.next();
				}
				
					input = SCAN.nextInt();
					SCAN.nextLine();
					
					if (input < min || input > max) {
						System.out.println("Please Enter a Valid Car ID Number");
					}
					else {
						validInput = true;
					}
			
		}while(!validInput);

		return input;
	}
}