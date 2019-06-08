package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Customer;
import com.revature.cardealership.pojo.Inventory;
import com.revature.cardealership.pojo.User;

public interface Screen {
	
	public User display(Inventory inventory);
	public int menuOptions(Inventory inventory, CarLot carLot, User user);
}
