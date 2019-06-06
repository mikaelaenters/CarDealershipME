package com.revature.cardealership.pojo;

import java.util.List;

public class CarLot {
	private List<Car> carLot;

	public CarLot(List<Car> carLot) {
		this.carLot = carLot;
	}
	
	public List<Car> getCarLot() {
		return this.carLot;
	}
	
	public void setCarLot(List<Car> carLot) {
		this.carLot = carLot;
	}
}
