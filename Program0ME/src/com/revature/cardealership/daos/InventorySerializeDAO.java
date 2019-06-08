package com.revature.cardealership.daos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.cardealership.pojo.Inventory;

public class InventorySerializeDAO implements InventoryDAO {

	private static final String FILENAME = "inventory.txt";
	@Override
	public void saveInventory(Inventory i) {
		ObjectOutputStream oos = null;
		FileOutputStream foo = null;

		try {
			foo = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(foo);
			oos.writeObject(i);

		} catch (FileNotFoundException e) {
			
		  } catch (IOException e) {
			
          } finally {
			try {
				if (oos != null) oos.close();

			} catch (IOException e) {
			
			  }

			try {
				if (foo != null) foo.close();
			} catch (IOException e) {
				
			}
		}
	}

	@Override
	public Inventory loadInventory() {
		Inventory myInventory = null;

		//try with resources

		try (FileInputStream fis = new FileInputStream(FILENAME);

				ObjectInputStream ois = new ObjectInputStream(fis);) {

			

			myInventory = (Inventory) ois.readObject();

			

		} catch (FileNotFoundException e) {

			
		} catch (IOException e) {

		

		} catch (ClassNotFoundException e) {

			

		}

		

		return myInventory;
	}

}
