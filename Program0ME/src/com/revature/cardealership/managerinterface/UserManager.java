package com.revature.cardealership.managerinterface;

import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.User;

public interface UserManager {
	
	public User createAnAccount(String userId, String password);
	public void login(User user);
	public void viewAllCars(CarLot carLot);
}
