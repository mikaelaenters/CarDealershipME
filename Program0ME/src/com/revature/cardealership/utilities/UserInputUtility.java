package com.revature.cardealership.utilities;

import java.util.Scanner;

import com.revature.cardealership.daos.CarDAO;
import com.revature.cardealership.daos.CarDAOPostgresImpl;
import com.revature.cardealership.daos.OfferDAO;
import com.revature.cardealership.daos.OfferDAOPostgresImpl;

public class UserInputUtility {
	
	private static final Scanner SCAN = new Scanner(System.in);
	private static boolean validInput;
	private static CarDAO cardao = new CarDAOPostgresImpl();
	private static OfferDAO offerdao = new OfferDAOPostgresImpl();
	
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
	
	public static int menuValidation(int min, int max) {
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
	
	public static int carIdPrompt() {
		int input;
		validInput = false;
		
		System.out.println("Please Enter the CAR ID Number: ");
		do {
				while(!SCAN.hasNextInt()) {
					System.out.println("Please Enter A Valid Car ID Number: ");
					SCAN.next();
				}
				
					input = SCAN.nextInt();
					SCAN.nextLine();
				if (cardao.getCarById(input) == null) {
					System.out.println("Please Enter A Valid Car ID Number: ");
				}
				else {
					validInput = true;
				}
		}while(!validInput);

		return input;
	}
	
	
	public static int offerIdPrompt() {
		int input;
		validInput = false;
		
		System.out.println("Please Enter the Offer ID Number: ");
		do {
				while(!SCAN.hasNextInt()) {
					System.out.println("Please Enter A Valid Offer ID Number: ");
					SCAN.next();
				}
				
					input = SCAN.nextInt();
					SCAN.nextLine();
				
				if (offerdao.getOfferById(input) == null) {
					System.out.println("Please Enter A Valid Offer ID Number: ");
				}
				else {
					validInput = true;
				}
		}while(!validInput);

		return input;
	}
	
	public static String makeAndModelPrompt(String reUsable) {
		String input = "";
		validInput = false;
		
		System.out.println("Please Enter the " + reUsable + " of the Car:");
		
			while(!SCAN.hasNext()) {
				System.out.println("Please Enter a Valid " + reUsable + " of the Car:");
				SCAN.next();
			}
			
			input = SCAN.next();
			SCAN.nextLine();
		
			return input;
	}
	
	public static double offerAmount() {
		double amount;
		validInput = false;
		
		System.out.println("How Much Would You Like To Offer On The CAR?");
		do {
			while(!SCAN.hasNextDouble()) {
				System.out.println("Please Enter A Valid Offer Price: ");
				SCAN.next();
			}
			
			amount = SCAN.nextDouble();
			SCAN.nextLine();
			if(amount >= 0) {
				validInput = true;
			}
			else {
				System.out.println("Please Enter A Non-Negative Offer Price: ");
			}
		}while(!validInput);
			return amount;
	}
	
	public static int getTheCarYear() {
		int input;
		validInput = false;
		System.out.println("Please Enter the Year of the Car: ");
			do {
				while(!SCAN.hasNextInt()) {
					System.out.println("Please Enter A Number: ");
					SCAN.next();
				}
				
					input = SCAN.nextInt();
					SCAN.nextLine();
					if(input >= 0) {
						validInput = true;
					}
					else {
						System.out.println("Years are not Negative! Please Enter a Postive Year: ");
					}
			}while(!validInput);		
		return input;
	}
	
	public static String retrieveUserId() {
		System.out.println("Please Enter Your Username: ");
		String input = SCAN.next();
		SCAN.nextLine();
		
		return input;
			
	}
	

	
	public static String getAccountInfo() {
		String input = SCAN.next();
		SCAN.nextLine();
		
		return input;
			
	}
}