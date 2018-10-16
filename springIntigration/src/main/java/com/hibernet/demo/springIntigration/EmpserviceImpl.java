package com.hibernet.demo.springIntigration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpserviceImpl implements EmpService {
	private SessionFactory sessionfactoy;

	public void setSessionfactoy(SessionFactory sessionfactoy) {
		this.sessionfactoy = sessionfactoy;
	}

	public void save(Employee e) {
		Session session = sessionfactoy.openSession();
		Transaction tr = session.beginTransaction();
		session.save(e);

		session.flush();
		tr.commit();
		session.close();

	}

	public List<Employee> emplist() {
		Session session = sessionfactoy.openSession();
		List<Employee> emp = session.createQuery("from myEmp").list();
		session.close();
		return emp;
	}

}

