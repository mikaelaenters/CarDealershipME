package com.revature.cardealership.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
	//Fields;
	private String carMake,
				   carModel;
	//private static int currentCarIndex = 0;
	private boolean active;
	private double monthlyPayment;
	private double totalCarPrice;
	private int carKey;
	private int carYear;
	
	//Constructors;
	public Car() {}
	
	public Car(int carKey, String carMake, String carModel, int carYear, 
			double totalCarPrice) { //Used for Customer Cars List
		this.carKey = carKey;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.totalCarPrice = totalCarPrice;
	}
	
	public Car (int carKey, String carMake, String carModel, int carYear){ //For carDAO
		this.carKey = carKey;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
	}
	
	public Car (String carMake, String carModel, int carYear){  //For newCar
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
	}

	
	//Getters &setters;
	
	public int getCarKey() {
		return carKey;
	}

	public void setCarKey(int carKey) {
		this.carKey = carKey;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	
	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getTotalCarPrice() {
		return this.totalCarPrice;
	}
	
	public void setTotalCarPrice(double totalCarPrice) {
		this.totalCarPrice = totalCarPrice;
	}
	
//	public int getNextIndex() {
//		return currentCarIndex + 1;
//	}
//	
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	
	public String getCarMake() {
		return this.carMake;
	}
	
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public String getCarModel() {
		return this.carModel;
	}

	public void setOwned(boolean active) {
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	//Methods;
	@Override
	public String toString() {
		return "[car identification= " + carKey + ", carMake= " + carMake + ", carModel= " + carModel + ", carYear= " 
					+ carYear + "]";
	}
}
