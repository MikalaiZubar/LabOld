package com.epam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.epam.domain.Book;
import com.epam.service.DBConnection;

public class BookDAOImplementation implements BookDAO {

	@Override
	public void updateBook() {
		// TODO Auto-generated method stub
		String title, newTitle;
		Connection connection = null;
		Statement st = null;
		try {
			connection = DBConnection.getConnection();
			st = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter old Title: ");
			title = sc.nextLine();
			System.out.println("Enter new Title: ");
			newTitle = sc.nextLine();
			String query = null;
			if (title.indexOf('*') >= 0) {
				System.out.println();
				query = "select id from book where title like '" + title.substring(0, title.indexOf('*')) + "%'";
			} else {
				query = "select id from book where title = '" + title + "'";
			}
			ResultSet rs = st.executeQuery(query);
			query = "update book set title=? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			while (rs.next()) {
				ps.setString(1, newTitle);
				ps.setInt(2, rs.getInt(1));
				ps.addBatch();
			}
			ps.executeBatch();
			sc.close();
			System.out.println("DataBase updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot connect to the database. Please check your configurations");
			// TODO: handle exception
		}
	}

	@Override
	public ArrayList<Integer> selectBooks() {
		ArrayList<Integer> books = new ArrayList<Integer>();
		Connection connection = null;
		Statement st = null;
		try {

			connection = DBConnection.getConnection();
			String query = "select id from book";
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				books.add(rs.getInt("id"));
			}
			if (st != null) {
				st.close();
			}
			if (connection != null)
				connection.close();
			return books;
		} catch (Exception e) {
			System.out.println("Cannot connect to the database. Please check your configurations");
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public void insertBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub

	}

}
