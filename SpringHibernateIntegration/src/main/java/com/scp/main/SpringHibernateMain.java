package com.scp.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scp.dao.PersonDAO;
import com.scp.model.Person;

public class SpringHibernateMain {


	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_context.xml");
		PersonDAO personDAO =context.getBean(PersonDAO.class);
		
		Person p1 = new Person();
		p1.setName("shona"); 
		p1.setCountry("India");
		personDAO.save(p1);
		
		
		Person p2 = new Person(10,"sumit","USA");
		personDAO.save(p2);
		
		Person p3 = new Person(3,"ashwini","pune");
		personDAO.save(p3);
		Person p4 = new Person(4,"sandeep","sangli");
		personDAO.save(p4);
		Person p5 = new Person(5,"suraj","latur");
		personDAO.save(p5);
		
		List<Person> list = personDAO.list();
		for (Person p : list) {
			System.out.println("Person List::"+p);
		}
		
		personDAO.updatePerson(2);
		
		personDAO.deletePerson(4);
		
	}

}
	