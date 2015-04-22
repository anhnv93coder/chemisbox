package com.chemisbox.dao.impl;

import java.util.ArrayList;
import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.entity.Chemical;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.utilities.ChemisboxUtilities;

@Repository
@Transactional
public class ChemicalDAOImpl implements ChemicalDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Chemical> list(String formula) throws ChemisboxException {
		if(ChemisboxUtilities.isNullOrEmpty(formula)){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		return (List<Chemical>)session.createCriteria(Chemical.class)
				.add(Restrictions.like("formula", formula)).list();
	}

	public Long add(Chemical c) throws ChemisboxException {
		if(c == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		return c.getId();
	}

	public boolean delete(Chemical c) throws ChemisboxException {
		if(c == null){
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(c);
		return true;
	}

	public Long update(Chemical c) throws ChemisboxException {
		if(c == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(c);
		return c.getId();
	}

	public Chemical get(Long id) throws ChemisboxException {
		if(id == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		Chemical chemical = (Chemical) session.get(Chemical.class, id);
		return chemical;
	}

	public Long get(String formula) throws ChemisboxException {
		if(ChemisboxUtilities.isNullOrEmpty(formula)){
			return null;
		}
		
		formula = ChemisboxUtilities.trimFullSize(formula);
		Session session = sessionFactory.getCurrentSession();
		Chemical obj = (Chemical) session.createCriteria(Chemical.class)
				.add(Restrictions.like("formula", formula)).uniqueResult();
		if (obj != null) {
			return obj.getId();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Chemical> list(int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Chemical>)session.createCriteria(Chemical.class).setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public Long getCount() throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(Chemical.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<String> selectFormulaAndNameList() throws ChemisboxException {
		List<String> masterList = new ArrayList<String>();
		Query query = sessionFactory.getCurrentSession().createSQLQuery("Select formula From chemical");
		List<String> formulaList = null;
		Object tempList = query.list();
		if(tempList instanceof List<?>){
			formulaList = (List<String>)tempList;
		}
		masterList.addAll(formulaList);
		return masterList;
	}

}
