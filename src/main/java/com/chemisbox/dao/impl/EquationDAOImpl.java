package com.chemisbox.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.EquationDAO;
import com.chemisbox.entity.Equation;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.utilities.ChemisboxUtilities;

@Repository
@Transactional
public class EquationDAOImpl implements EquationDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Equation> selectByChemical(String chemical, int typeOf, int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("callGetEquationByChemical")
				.setParameter("chemical", chemical)
				.setParameter("typeOf", typeOf)
				.setParameter("startIndex", startIndex)
				.setParameter("pageSize", pageSize);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Equation> selectByChemicals(String leftChemical,
			String rightChemical) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("callGetEquationsByLeftRight")
				.setParameter("leftChemical", leftChemical)
				.setParameter("rightChemical", rightChemical);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Equation> selectByChemicals(String chemical1, String chemical2,
			int typeOf, int startIndex, int pageSize) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("callGetEquationBy2Chemical")
				.setParameter("chemical1", chemical1)
				.setParameter("chemical2", chemical2)
				.setParameter("typeOf", typeOf)
				.setParameter("startIndex", startIndex)
				.setParameter("pageSize", pageSize);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Equation> selectByChemicals(String chemical1, String chemical2,
			String chemical3, int typeOf, int startIndex, int pageSize) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("callGetEquationBy3Chemical")
				.setParameter("chemical1", chemical1)
				.setParameter("chemical2", chemical2)
				.setParameter("chemical3", chemical3)
				.setParameter("typeOf", typeOf)
				.setParameter("startIndex", startIndex)
				.setParameter("pageSize", pageSize);
		return query.list();
	}

	public Long add(Equation e) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
		return e.getEquationId();
	}

	public boolean delete(Equation e) throws ChemisboxException {
		if (e == null) {
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		session.delete(e);
		return true; 
	}

	public Long update(Equation e) throws ChemisboxException {
		if(e == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		session.update(e);
		return e.getEquationId();
	}

	public Equation get(Long id) throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Equation equation = (Equation) session.get(Equation.class, id);
		return equation;
	}

	@SuppressWarnings("unchecked")
	public List<Equation> list(int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		return (List<Equation>)session.createCriteria(Equation.class).setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public Long getCount() {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(Equation.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Equation> selectByChemical(String chemical, int startIndex, int pageSize)
			throws ChemisboxException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("callGetEquation")
				.setParameter("chemical", chemical)
				.setParameter("startIndex", startIndex)
				.setParameter("pageSize", pageSize);
		return query.list();
	}
	

	@SuppressWarnings("unchecked")
	public List<Equation> searchByKeyWord(String keyWord, int startIndex, int pageSize) {
		if (ChemisboxUtilities.isNullOrEmpty(keyWord)) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		return session
				.createCriteria(Equation.class)
				.add(Restrictions.like("equation", keyWord))
				.setFirstResult(startIndex).setMaxResults(pageSize).list();
	}

	public Long getCountByKeyWord(String keyWord) throws ChemisboxException {
		if (ChemisboxUtilities.isNullOrEmpty(keyWord)) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		return (Long) session
				.createCriteria(Equation.class)
				.add(Restrictions.like("equation", keyWord))
				.setProjection(Projections.rowCount()).uniqueResult();
	}


}
