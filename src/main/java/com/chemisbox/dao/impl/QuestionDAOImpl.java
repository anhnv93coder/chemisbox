package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Question> selectLastestQuestion(int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Question>) session
				.createCriteria(Question.class)
				.add(Restrictions.eq("approved",
						ChemisboxConstant.QUESTION_IS_APPROVED))
				.addOrder(Order.desc("createdDate")).setFirstResult(startIndex)
				.setMaxResults(pageSize).list();
	}

	@SuppressWarnings("unchecked")
	public List<Question> selectQuestionByUser(String email, int startIndex,
			int pageSize) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.email", email));
		return (List<Question>) criteria.setFirstResult(startIndex)
				.setMaxResults(pageSize).list();
	}

	public List<Question> selectHotQuestion(int startIndex, int pageSize)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer add(Question question) throws ChemisboxException {
		if (question == null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(question);
		return question.getQuestionId();
	}

	public Integer update(Question question) throws ChemisboxException {
		if (question == null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(question);
		return question.getQuestionId();
	}

	public boolean delete(Question question) throws ChemisboxException {
		if (question == null) {
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(question);
		return true;
	}

	public Question get(Integer id) throws ChemisboxException {
		if (id == null) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Question question = (Question) session.get(Question.class, id);
		return question;
	}

	@SuppressWarnings("unchecked")
	public List<Question> selectNotApprovedQuestions(int startIndex,
			int pageSize) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Question>) session
				.createCriteria(Question.class)
				.add(Restrictions.eq("approved",
						ChemisboxConstant.QUESTION_IS_NOT_APPROVED))
				.addOrder(Order.desc("createdDate")).setFirstResult(startIndex)
				.setMaxResults(pageSize).list();
	}

	public boolean doApprove(Integer id) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		String hqlUpdate = "Update Question q set approved = :approved where questionId = :questionId";
		int result = session.createQuery(hqlUpdate)
				.setInteger("approved", ChemisboxConstant.QUESTION_IS_APPROVED)
				.setInteger("questionId", id).executeUpdate();
		return result > 0 ? true : false;
	}

	public boolean doVoteGoodAnswer(Integer questionId, Integer answerId)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		String hqlUpdate = "Update Question q set q.goodAnswerId = :answerId where q.questionId = :questionId";
		int result = session.createQuery(hqlUpdate)
				.setInteger("answerId", answerId)
				.setInteger("questionId", questionId).executeUpdate();
		return result > 0 ? true : false;
	}

	public Long getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(Question.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	public Long getQuestionIsNotAprroved() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session
				.createCriteria(Question.class)
				.add(Restrictions.eq("approved",
						ChemisboxConstant.QUESTION_IS_NOT_APPROVED))
				.setProjection(Projections.rowCount()).uniqueResult();
	}
}
