package com.chemisbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.chemisbox.dao.AdminDAO;
import com.chemisbox.entity.Admin;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.utilities.ChemisboxUtilities;

public class AdminDAOImpl implements AdminDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Admin authenticate(String username, String password)
			throws ChemisboxException {
		Admin result = null;
		if (ChemisboxUtilities.isNullOrEmpty(username)
				|| ChemisboxUtilities.isNullOrEmpty(password)) {
			return result;
		}
		Session session = sessionFactory.getCurrentSession();
		result = (Admin) session.createCriteria(Admin.class).add(
				Restrictions.and(Restrictions.eq("userName", username), Restrictions.eq("password", password))).uniqueResult();
		return result;
	}

	public boolean update(Admin admin) throws ChemisboxException {
		try {
			if (admin == null) {
				return false;
			}
			Session session = sessionFactory.getCurrentSession();
			session.update(admin);
			return true;
		} catch (Exception e) {
			 throw new ChemisboxException(e);
		}
	}

}
