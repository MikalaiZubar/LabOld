package com.epam.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.domain.Employee;
import com.epam.service.DBConnection;

public class EmployeeDAOimplementation implements EmployeeDAO {

	@Override
	public ArrayList<Integer> selectEmployees(){
		ArrayList<Integer> books = new ArrayList<Integer>();
		Connection connection = null;
		Statement st = null;
		try{
			
			connection = DBConnection.getConnection();
			String query = "select id from employee";
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				books.add(rs.getInt("id"));
			}
			if(st != null){
				st.close();
			}
			if(connection != null)
				connection.close();
			return books;
		}catch (Exception e) {
			System.out.println("Cannot connect to the database. Please check your configurations");
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
