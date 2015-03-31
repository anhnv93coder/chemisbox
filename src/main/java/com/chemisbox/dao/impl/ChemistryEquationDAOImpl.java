package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.ChemistryEquationDAO;
import com.chemisbox.entity.ChemistryEquation;

@Repository
@Transactional
public class ChemistryEquationDAOImpl implements ChemistryEquationDAO {

	private SessionFactory sessionFactory;

	public boolean add(ChemistryEquation chemistryEquation) {
		Session session = sessionFactory.getCurrentSession();
		session.save(chemistryEquation);
		return false;
	}

	public boolean delete(ChemistryEquation chemistryEquation) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(chemistryEquation);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<ChemistryEquation> list() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from ChemistryEquation").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
