package com.epam.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() {
		//System.out.println("In connections");
		Properties configurations = new Properties();   //To get the db configurations
		FileInputStream dbConfigurationFile = null;            //Reading the properties file
		Connection connnection = null;				   //For connection	
		try {
			dbConfigurationFile = new FileInputStream("dbConfigurations.properties");
			configurations.load(dbConfigurationFile);
			
			// To load the driver class
			//System.out.println(configurations.getProperty("DB_DRIVER_CLASS"));
			Class.forName(configurations.getProperty("DB_DRIVER_CLASS"));

			// For creating the connection
			String url = configurations.getProperty("DB_URL")+"?autoReconnect=true&useSSL=false";
			connnection = DriverManager.getConnection(url,configurations.getProperty("DB_USERNAME"),configurations.getProperty("DB_PASSWORD"));
		}
		catch (IOException e) {
			e.printStackTrace();   		
			//Exceptions during file I/O
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();			
			//Exceptions while loading the class
		}
		catch (SQLException e) {
			e.printStackTrace(); 
			//AnyOther SQL related exception
		}
		return connnection;
	}
}
