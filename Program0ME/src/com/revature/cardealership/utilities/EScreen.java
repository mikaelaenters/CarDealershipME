package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.CarLot;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Inventory;

public interface EScreen {
	public Employee display(Inventory inventory);
	public int menuOptions(Inventory inventory, CarLot carLot, Employee user);
}
