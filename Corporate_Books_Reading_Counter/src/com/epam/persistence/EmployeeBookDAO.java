package com.epam.persistence;

import java.util.ArrayList;

import com.epam.domain.Relation;

public interface EmployeeBookDAO {

	public ArrayList<?> selectRelation();

	public void populateTable();

	public void insertRelation(Relation relation);

	public void updateRelation();

	public void deleteRelation(Relation relation);

}
