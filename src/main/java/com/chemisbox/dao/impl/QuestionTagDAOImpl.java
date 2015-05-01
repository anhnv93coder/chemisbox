package com.chemisbox.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chemisbox.dao.QuestionTagDAO;
import com.chemisbox.entity.QuestionTag;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class QuestionTagDAOImpl implements QuestionTagDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean add(QuestionTag questionTag) throws ChemisboxException {
		if(questionTag == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(questionTag);
		return true;
	}

	public boolean delete(QuestionTag questionTag) throws ChemisboxException {
		if(questionTag == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(questionTag);
		return true;
	}



}
