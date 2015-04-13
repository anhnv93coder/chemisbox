package com.chemisbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.OxiReduceEquationDAO;
import com.chemisbox.entity.OxiReduceEquation;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class OxiReduceEquationDAOImpl implements OxiReduceEquationDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long add(OxiReduceEquation oxi) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(oxi);
			return oxi.getOxiReduceId();
		} catch (Exception e) {
		}
		return null;
	}

	public Long update(OxiReduceEquation oxi) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(oxi);
			return oxi.getOxiReduceId();
		} catch (Exception e) {
		}
		return null;
	}

	public OxiReduceEquation get(Long id) throws ChemisboxException {
		OxiReduceEquation oxi = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			if(id == null){
				return oxi;
			}
			oxi = (OxiReduceEquation) session.get(OxiReduceEquation.class, id);
		} catch (Exception e) {
		}
		return oxi;
	}

	public Long delete(OxiReduceEquation oxi) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(oxi);
			return oxi.getOxiReduceId();
		} catch (Exception e) {
		}
		return null;
	}

}
