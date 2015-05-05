package com.chemisbox.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chemisbox.constant.ChemisboxConstant;
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

	public boolean delete(Integer questionId) throws ChemisboxException {
		if(questionId == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		String hqlUpdate = "Delete From QuestionTag qt where qt.question.questionId = :questionId";
		int result = session.createQuery(hqlUpdate)
				.setInteger("questionId", questionId).executeUpdate();
		return result > 0 ? true : false;
	}



}
