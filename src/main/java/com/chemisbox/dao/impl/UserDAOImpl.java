package com.chemisbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	public String register(User user) throws ChemisboxException {
		if(user == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user.getEmail();
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

}
