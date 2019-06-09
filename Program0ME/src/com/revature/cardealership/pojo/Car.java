package com.revature.cardealership.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
	//Fields;
	private String carMake,
				   carModel;
	private List<Offer> carOffers = new ArrayList<Offer>(); 
	//private boolean owned;
	//private double monthlyPayment;
	
	
	//Constructors;
	public Car(String carMake, String carModel) {
		this.carMake = carMake;
		this.carModel = carModel;
		
		
	}
	
	//Getters &setters;
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
//	public void setMonthlyPayment(double monthlyPayment) {
//		this.monthlyPayment = monthlyPayment;
//	}
//
//	public double getMonthlyPayment() {
//		return this.monthlyPayment;
//	}
	
	//Methods;
	
	public void addCarOfferToList(Offer offer) {
		this.carOffers.add(offer);
	}
	@Override
	public String toString() {
		return "[carMake=" + carMake + ", carModel=" + carModel + "]";
	}
}
