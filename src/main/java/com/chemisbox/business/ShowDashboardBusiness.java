package com.chemisbox.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.dao.ElementDAO;
import com.chemisbox.dao.EquationDAO;
import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.dao.UserDAO;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.ShowDashboardInputParam;
import com.chemisbox.output.ShowDashboardOutputParam;

public class ShowDashboardBusiness extends
		ChemisboxBusiness<ShowDashboardInputParam, ShowDashboardOutputParam> {

	@Autowired
	private ElementDAO elementDao;
	
	@Autowired
	private ChemicalDAO chemicalDao;
	
	@Autowired
	private EquationDAO equationDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private QuestionDAO questionDao;

	@Override
	public ShowDashboardOutputParam execute(ShowDashboardInputParam inParam)
			throws ChemisboxException {
		this.out = new ShowDashboardOutputParam();
		try {
			Long elementCounter = elementDao.getCount();
			Long chemicalCounter = chemicalDao.getCount();
			Long equationCounter = equationDao.getCount();
			Long userCounter = userDao.getCount();
			Long questionCounter = questionDao.getCount();
			Long questionIsNotApprovedCounter = questionDao.getQuestionIsNotAprroved();
			
			this.out.setChemicalCounter(chemicalCounter);
			this.out.setElementCounter(elementCounter);
			this.out.setEquationCounter(equationCounter);
			this.out.setQuestionCounter(questionCounter);
			this.out.setQuestionIsNotApprovedCounter(questionIsNotApprovedCounter);
			this.out.setUserCounter(userCounter);
			
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage("Xảy ra lỗi. Vui lòng liên hệ với quản trị.");
		}
		return this.out;
	}

	public void setElementDao(ElementDAO elementDao) {
		this.elementDao = elementDao;
	}

	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

	public void setEquationDao(EquationDAO equationDao) {
		this.equationDao = equationDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

}
