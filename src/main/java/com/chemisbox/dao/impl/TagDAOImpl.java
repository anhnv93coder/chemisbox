package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.chemisbox.dao.TagDAO;
import com.chemisbox.entity.Tag;
import com.chemisbox.exception.ChemisboxException;

public class TagDAOImpl implements TagDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Tag> selectByQuestion() throws ChemisboxException {
//		sessionFactory.getCurrentSession().
		return null;
	}

	public Integer add(Tag tag) throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(Tag tag) throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(Tag tag) throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

	public Tag get(Integer id) throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
