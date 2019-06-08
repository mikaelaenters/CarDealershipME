package com.revature.cardealership.daos;

import com.revature.cardealership.pojo.Inventory;

public interface InventoryDAO {

	public void saveInventory(Inventory i);
	public Inventory loadInventory();
}
