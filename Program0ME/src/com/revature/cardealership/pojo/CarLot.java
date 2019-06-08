package com.revature.cardealership.pojo;

import java.util.ArrayList;
import java.util.List;

public class CarLot {
	private List<Car> carLot;

	public CarLot() {
		carLot = new ArrayList<Car>();
	}
	
	public List<Car> getCarLot() {
		return this.carLot;
	}
	
	public void addCarToLot(String make, String model) {
		this.carLot.add(new Car(make,model));
	}
	
	public void removeCarFromLot(int index) {
		this.carLot.remove(index);
	}
}
