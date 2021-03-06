package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.ElementDAO;
import com.chemisbox.entity.Element;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.utilities.ChemisboxUtilities;

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
		session.update(c);	
		return c.getNotation();
	}

	public Element get(String notation)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Element) session.get(Element.class, notation);
	}

	@SuppressWarnings("unchecked")
	public List<Element> getByKeyWord(String keyWord)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Element.class).add(
				Restrictions.or(Restrictions.eq("notation", keyWord), Restrictions.eq("name", keyWord))).list();
	}

	@SuppressWarnings("unchecked")
	public List<Element> list(int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Element>)session.createCriteria(Element.class).setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public Long getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(Element.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Element> searchByKeyWord(String keyWord, int startIndex, int pageSize) {
		if (ChemisboxUtilities.isNullOrEmpty(keyWord)) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		return session
				.createCriteria(Element.class)
				.add(Restrictions.or(Restrictions.like("notation", keyWord),
						Restrictions.like("name", keyWord)))
				.setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public Long getCountByKeyWord(String keyWord) throws ChemisboxException {
		if (ChemisboxUtilities.isNullOrEmpty(keyWord)) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		return (Long) session
				.createCriteria(Element.class)
				.add(Restrictions.or(Restrictions.like("notation", keyWord),
						Restrictions.like("name", keyWord)))
				.setProjection(Projections.rowCount()).uniqueResult();
	}

}
