package com.revature.cardealership.postgresqlutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	//Singletons &Factory
	//Singleton is a class that can only be instantiated once
	private static String url;
	private static String user;
	private static String password;
	private static final String PROPERTIES_FILE = "src/main/resources/database.properties";
	private static ConnectionFactory cf;
	
	public static synchronized Connection getConnection() {
		if(cf == null) {
			cf = new ConnectionFactory();
		}
		
		return cf.createConnection();
	}
	
	
	
	private ConnectionFactory() {
		//private constructor makes this a singleton
		Properties prop = new Properties();
		try(FileInputStream fis = new FileInputStream(PROPERTIES_FILE);){
			prop.load(fis);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			//**/*.properties in gitignore
			//must do git add .gitignore
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private Connection createConnection() {
		Connection conn = null; 
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			System.out.println("Failed to make connection...");
		}
		
		return conn;
	}
}
