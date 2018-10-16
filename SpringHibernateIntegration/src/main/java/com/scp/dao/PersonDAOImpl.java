package com.scp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.model.Person;

public class PersonDAOImpl implements PersonDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();

	}

	public List<Person> list() {
		Session session=this.sessionFactory.openSession();
		List<Person>peronList=session.createQuery("from Person").list();
		session.close();
		return peronList;
	}

	public Person updatePerson(int id) {
		
		Session session=this.sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Person p2=(Person)session.get(Person.class, id);
		p2.setName("Rishabh");
		
		System.out.println("updated person is"+p2);
		session.update(p2);
		tr.commit();
		session.close();
		return p2;
	}

	public void deletePerson(int id) {
		Session session=this.sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Person p2=(Person)session.get(Person.class, id);
		
		session.delete(p2);
		System.out.println("deleted......");
		tr.commit();		
		session.close();
		
		
	}


}	