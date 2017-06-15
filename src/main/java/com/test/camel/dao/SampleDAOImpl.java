package com.test.camel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.test.camel.model.Sample;

public class SampleDAOImpl implements SampleDAO{

	private SessionFactory sessionFactory;
	
	public void save(Sample s) {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(s);
		tx.commit();
		session.close();
		
	}

	public List<Sample> list() {
		
		Session session = this.sessionFactory.openSession();
		List<Sample> list = session.createQuery("from Sample").list();
		session.close();
		
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
