package com.chemisbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.UserDAO;
import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.utilities.ChemisboxUtilities;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean register(User user) throws ChemisboxException {
		if(user == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	public String update(User user) throws ChemisboxException {
		if(user == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return user.getEmail();
	}

	public User authenticate(String email, String password)
			throws ChemisboxException {
		User result = null;
		if (ChemisboxUtilities.isNullOrEmpty(email)
				|| ChemisboxUtilities.isNullOrEmpty(password)) {
			return result;
		}
		Session session = sessionFactory.getCurrentSession();
		result = (User) session.createCriteria(User.class).add(
				Restrictions.and(Restrictions.eq("email", email), Restrictions.eq("password", password))).uniqueResult();
		return result;
	}

	public User get(String email) throws ChemisboxException {
		if(ChemisboxUtilities.isNullOrEmpty(email)){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		User result = (User) session.createCriteria(User.class).add(
				Restrictions.and(Restrictions.eq("email", email))).uniqueResult();
		return result;
	}

	public Long getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(User.class).setProjection(Projections.rowCount()).uniqueResult();
	}
	
}
