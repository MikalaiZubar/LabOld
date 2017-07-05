package com.epam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.epam.domain.Relation;
import com.epam.service.DBConnection;

public class TestClass {

	public static void main(String[] args) {
		System.out.println("Add");
		TestClass ts = new TestClass();
		ts.updateBook();
	}

	public void populate() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> employees = new ArrayList<Integer>();
		ArrayList<Integer> books = new ArrayList<Integer>();
		Set<Relation> relationData = new HashSet<Relation>();
		int id = 0;
		System.out.println("Enter data: ");
		for (int i = 0; i < 5; i++) {
			int emp = Integer.parseInt(sc.next());
			employees.add(emp);
			int book = Integer.parseInt(sc.next());
			books.add(book);
			System.out.println("Added: " + emp + " : " + book);
		}
		while (id < 5) {
			boolean flag = false;
			Relation relation = new Relation(employees.get((int) (Math.random() * employees.size())),
					books.get((int) (Math.random() * books.size())), id);
			for (Relation r : relationData) {
				if (r.equals(relation))
					flag = true;
			}
			if (!flag) {
				relationData.add(relation);
				id++;
			}
		}

		Iterator<Relation> itr = relationData.iterator();
		while (itr.hasNext()) {
			Relation relation = itr.next();
			System.out.println("id : " + relation.getId() + "   | emp : " + relation.getEmp_id() + "   | book : "
					+ relation.getBook_id());
		}
		sc.close();
	}

	public void getEmployeesWhoReadMoreThanOneBook() {
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
	
	public void updateBook() {
		// TODO Auto-generated method stub
		String title, newTitle;
		Connection connection = null;
		Statement st = null;
		try{
			connection = DBConnection.getConnection();
			st = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter old Title: ");
			title = sc.nextLine();
			System.out.println("Enter new Title: ");
			newTitle = sc.nextLine();
			String query = null;
			if(title.indexOf('*')>=0){
				System.out.println();
				query = "select id from book where title like '"+title.substring(0, title.indexOf('*'))+"%'";
			}
			else{
				query = "select id from book where title = '"+title+"'";
			}
			ResultSet rs = st.executeQuery(query);
			query = "update book set title=? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			while(rs.next()){
				ps.setString(1, newTitle);
				ps.setInt(2, rs.getInt(1));
				ps.addBatch();
			}
			ps.executeBatch();
			sc.close();
			System.out.println("DataBase updated");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot connect to the database. Please check your configurations");
			// TODO: handle exception
		}
	}
}
