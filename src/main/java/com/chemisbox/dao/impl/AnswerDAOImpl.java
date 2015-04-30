package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.AnswerDAO;
import com.chemisbox.entity.Answer;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class AnswerDAOImpl implements AnswerDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Answer> selectByQuestion(Integer questionId) throws ChemisboxException {
		if(questionId == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Answer.class);
		criteria.createAlias("question", "q");
		criteria.add(Restrictions.eq("q.questionId", questionId));
		return criteria.list(); 
	}

	public Integer add(Answer answer) throws ChemisboxException {
		if(answer == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(answer);
		return answer.getAnswerId();
	}

	public Integer update(Answer answer) throws ChemisboxException {
		if(answer == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(answer);
		return answer.getAnswerId();
	}

	public boolean delete(Answer answer) throws ChemisboxException {
		if(answer == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(answer);
		return true;
	}

	public Answer get(Integer id) throws ChemisboxException {
		if(id == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Answer answer = (Answer) session.get(Answer.class, id);
		return answer;
	}

}
