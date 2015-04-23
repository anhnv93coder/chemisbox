package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.FeedbackDAO;
import com.chemisbox.entity.Feedback;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class FeedbackDAOImpl implements FeedbackDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Integer add(Feedback feedback) throws ChemisboxException {
		if(feedback == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(feedback);
		return feedback.getId();
	}

	public boolean delete(Feedback feedback) throws ChemisboxException {
		if(feedback == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(feedback);
		return true;
	}

	public Feedback get(Integer id) throws ChemisboxException {
		if(id == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Feedback feedback = (Feedback) session.get(Feedback.class, id);
		return feedback;
	}

	public Integer getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.createCriteria(Feedback.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> list(int startIndex, int pageSize) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Feedback>)session.createCriteria(Feedback.class).setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

}
