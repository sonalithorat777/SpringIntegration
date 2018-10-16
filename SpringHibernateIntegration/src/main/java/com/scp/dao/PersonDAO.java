package com.scp.dao;

import java.util.List;

import com.scp.model.Person;

public interface PersonDAO {
	
public void save(Person p);
	
	public List<Person> list();
	
	public Person updatePerson(int id);
	
	public void deletePerson(int id);
	
	
	

}
