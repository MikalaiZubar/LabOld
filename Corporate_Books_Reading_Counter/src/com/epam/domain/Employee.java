package com.epam.domain;

import java.sql.Date;

public class Employee {

	private int id;
	private String employee_name;
	private Date date_of_birth;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(int id, String employee_name, Date date_of_birth, String email) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.date_of_birth = date_of_birth;
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employee_name == null) ? 0 : employee_name.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Employee) {
			Employee employee = (Employee) obj;
			return ((employee.getId() == this.getId()) || (employee.getEmployee_name().equals(this.getEmployee_name())
					&& employee.getDate_of_birth().equals(this.getDate_of_birth())
					&& employee.getEmail().equals(this.getEmail())));
		} else {
			return false;
		}
	}

}
