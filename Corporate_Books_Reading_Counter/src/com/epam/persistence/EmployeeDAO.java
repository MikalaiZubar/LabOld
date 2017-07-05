package com.epam.persistence;

import java.util.ArrayList;

import com.epam.domain.Employee;

public interface EmployeeDAO {

	public ArrayList<?> selectEmployees();
	public void insertEmployee(Employee employee);
	public void updateEmployee();
	public void deleteEmployee(Employee employee);
}
