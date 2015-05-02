package com.chemisbox.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chemisbox.dao.TagDAO;
import com.chemisbox.entity.Tag;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class TagDAOImpl implements TagDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Tag> selectByQuestion() throws ChemisboxException {

		return null;
	}

	public Integer add(Tag tag) throws ChemisboxException {
		if(tag == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(tag);
		return tag.getTagId();
	}

	public Integer update(Tag tag) throws ChemisboxException {
		if(tag == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(tag);
		return tag.getTagId();
	}

	public boolean delete(Tag tag) throws ChemisboxException {
		if(tag == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(tag);
		return true;
	}

	public Tag get(String tagName) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Tag) session.createCriteria(Tag.class).add(Restrictions.like("tagName", tagName)).uniqueResult();
	}

	public Long getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(Tag.class).setProjection(Projections.rowCount()).uniqueResult();
	}

}
