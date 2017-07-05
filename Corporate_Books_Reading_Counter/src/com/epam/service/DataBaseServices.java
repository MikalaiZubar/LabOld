package com.epam.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.epam.persistence.BookDAOImplementation;
import com.epam.persistence.EmployeeBookDAOImplementation;

public class DataBaseServices {

	public void populateTable() {
		EmployeeBookDAOImplementation eb = new EmployeeBookDAOImplementation();
		eb.populateTable();
	}

	public void updateTitle() {
		BookDAOImplementation bk = new BookDAOImplementation();
		bk.updateBook();
	}

	public void getEmployeesWhoReadMoreThanOneBook() {
		Connection connection = null;
		System.out.println("In 1");
		try {
			connection = DBConnection.getConnection();
			Statement st = connection.createStatement();
			System.out.println("Connection created....");
			String query = "select employee_name, number_of_books from employee inner join (select employee_id, count(*) as number_of_books "
					+ "from employee_book GROUP BY employee_id) as t on employee.id=t.employee_id where number_of_books<10";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.format("\t%12s : %2d\n", rs.getString(1), rs.getInt(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("unable to process your request");
		}
	}

	public void getEmployeesWhoReadLessThanOrEqualToTwoBook() {
		Connection connection = null;
		System.out.println("In 1");
		try {
			connection = DBConnection.getConnection();
			Statement st = connection.createStatement();
			System.out.println("Connection created....");
			String query = "select employee_name, date_of_birth, cnt from employee left outer join (select employee_id,count(*) as cnt from employee_book"
					+" GROUP BY employee_id) as t on employee.id=t.employee_id where ((cnt<=2) or (cnt is null))";
			ResultSet rs = st.executeQuery(query);
			System.out.println("      Employee Name , Date 0f birth : Number of books");
			while (rs.next()) {
				System.out.format("\t%12s, %s    : %2d\n", rs.getString(1), rs.getDate(2).toString(),rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("unable to process your request");
		}
	}
}
