package com.epam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.epam.domain.Relation;
import com.epam.service.DBConnection;

public class EmployeeBookDAOImplementation implements EmployeeBookDAO {

	@Override
	public void populateTable() {
		// TODO Auto-generated method stub
		ArrayList<Integer> books = null;
		ArrayList<Integer> employees = null;
		BookDAOImplementation booksData = new BookDAOImplementation();
		books = booksData.selectBooks();
		System.out.println("Got bks");
		EmployeeDAOimplementation employeesData = new EmployeeDAOimplementation();
		employees = employeesData.selectEmployees();
		System.out.println("Got emps");
		Set<Relation> relationData = new HashSet<Relation>();
		int id = 1;
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

		Connection connection = null;
		PreparedStatement st = null;
		String query = "insert into employee_book(id, employee_id,book_id) values(?,?,?)";
		try {
			connection = DBConnection.getConnection();
			st = connection.prepareStatement(query);
			Iterator<Relation> itr = relationData.iterator();
			while (itr.hasNext()) {
				Relation relation = itr.next();
				st.setInt(1, relation.getId());
				st.setInt(2, relation.getEmp_id());
				st.setInt(3, relation.getBook_id());
				st.addBatch();
			}
			st.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public ArrayList<?> selectRelation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRelation(Relation relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRelation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRelation(Relation relation) {
		// TODO Auto-generated method stub

	}

}
