package com.revature.cardealership.pojo;

import java.io.Serializable;
import java.util.List;

public class Customer extends User implements Serializable{
	//Fields;
	private List<Car> ownedCars;
	private double totalCarPrice;   //This will get set when they get a car
	//Constructors;
	public Customer(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	//Getters &Setters;
	public List<Car> getOwnedCars() {
		return this.ownedCars;
	}
	
	public void setOwnedCars(Car car) {
		ownedCars.add(car);
	}
	
	public void setOwnedCars(List<Car> ownedCars) {
		this.ownedCars = ownedCars;
	}
	
	public double getTotalCarPrice() {
		return this.totalCarPrice;
	}
	
	public void setTotalCarPrice(double totalCarPrice) {
		this.totalCarPrice = totalCarPrice;
	}
}
