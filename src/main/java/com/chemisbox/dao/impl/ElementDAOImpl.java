package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.ElementDAO;
import com.chemisbox.entity.Element;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class ElementDAOImpl implements ElementDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Element> list() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Element").list();
	}

	public String add(Element c) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		return c.getNotation();
	}

	public String delete(Element c)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(c);
		return c.getNotation();
	}

	public String update(Element c)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(c);
		return c.getNotation();
	}

	public Element get(String notation)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Element) session.get(Element.class, notation);
	}

	@SuppressWarnings("unchecked")
	public List<Element> list(int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Element>)session.createCriteria(Element.class).setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public Integer getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.createCriteria(Element.class).setProjection(Projections.rowCount()).uniqueResult();
	}

}
