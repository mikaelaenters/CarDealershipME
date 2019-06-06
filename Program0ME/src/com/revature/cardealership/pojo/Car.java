package com.revature.cardealership.pojo;

import java.util.List;

public class Car {
	//Fields;
	private String ownerFirstName,
				   ownerLastName, 
				   carMake,
				   carModel;
	private List<Offer> carOffers; 
	//private boolean owned;
	private double monthlyPayment;
	
	//Constructors;
	public Car(String carMake, String carModel) {
		this.carMake = carMake;
		this.carModel = carModel;
	}
	
	//Getters &setters;
	
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	
	public String getOwnerFirstName() {
		return this.ownerFirstName;
	}
	
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	
	public String getOwnerLastName() {
		return this.ownerLastName;
	}

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
	
	
	
	public List<Offer> getCarOffers() {
		return this.carOffers;
	}

	public void setCarOffers(List<Offer> carOffers) {
		this.carOffers = carOffers;
	}

	//	public void setOwned(boolean owned) {
//		this.owned = owned;
//	}
//	
//	public boolean getOwned() {
//		return this.owned;
//	}
//	
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getMonthlyPayment() {
		return this.monthlyPayment;
	}
	
	//Methods;
	@Override
	public String toString() {
		return "Car [carMake=" + carMake + ", carModel=" + carModel + ", monthlyPayment=" + monthlyPayment + "]";
	}
}
