package com.epam.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBase {
	
	private static final Logger LOGGER = LogManager.getLogger(DataBase.class);
	private static final String DATABASE_PROPS = "database";
	private static ResourceBundle rb;
	private static Connection cn;
	
	
	private DataBase(){
		cn = createConnection();
	}
	
	private static class DAOHolder{
		private static final DataBase DB = new DataBase();
	}
	
	public static DataBase getDataBase(){
		return DAOHolder.DB;
	}
	
	public Connection getCn() {
		return cn;
	}
	
	private Connection createConnection(){
		try {
			rb = ResourceBundle.getBundle(DATABASE_PROPS);
			Class.forName(rb.getString("db.driver"));
			String url = rb.getString("db.url");
			String user = rb.getString("db.user");
			String pass = rb.getString("db.password");
			try {
				cn = (Connection) DriverManager.getConnection(url, user, pass);
				return cn;
			} catch (SQLException e) {
				LOGGER.error("DB connection error", e);
			}
		} catch (ClassNotFoundException e) {
			LOGGER.error("Driver load error.", e);
		}
		return null;
	}
	
	public static void closeConnection(){
		try {
			cn.close();
		} catch (SQLException e) {
			LOGGER.error("Connection closing error.", e);
		}
	}
		
}
