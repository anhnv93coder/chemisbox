package com.chemisbox.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.IonEquationDAO;
import com.chemisbox.entity.IonEquation;
import com.chemisbox.exception.ChemisboxException;

@Repository
@Transactional
public class IonEquationDAOImpl implements IonEquationDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Long add(IonEquation ion) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		try {
			if(ion == null){
				return null;
			}
			session.save(ion);
			return ion.getIonId();
		} catch (Exception e) {
		}
		return null;
	}

	public Long update(IonEquation ion) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		try {
			if(ion == null){
				return null;
			}
			session.update(ion);
			return ion.getIonId();
		} catch (Exception e) {
			
		}
		return null;
	}

	public IonEquation get(Long id) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		IonEquation ion = null;
		try {
			if(id == null){
				return ion;
			}
			ion = (IonEquation) session.get(IonEquation.class, id);
		} catch (Exception e) {
			
		}
		return ion;
	}

	public Long delete(IonEquation ion) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		try {
			if(ion == null){
				return null;
			}
			session.delete(ion);
			return ion.getIonId();
		} catch (Exception e) {
			
		}
		return null;
	}

}
