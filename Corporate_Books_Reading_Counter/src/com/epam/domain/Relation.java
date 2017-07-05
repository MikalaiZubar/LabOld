package com.epam.domain;

public class Relation {

	private int emp_id;
	private int book_id;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	public int getBook_id() {
		return book_id;
	}
	
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public Relation(int emp_id, int book_id, int id) {
		super();
		this.emp_id = emp_id;
		this.book_id = book_id;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_id;
		result = prime * result + emp_id;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Relation) {
            Relation pp = (Relation) obj;
            return ((pp.getEmp_id() == this.getEmp_id() && pp.getBook_id() == this.getBook_id()) || 
            		pp.getId() == this.getId());
        } else {
            return false;
        }
	}
	
}
