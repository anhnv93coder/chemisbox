package com.chemisbox.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.AnswerDAO;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadAskQuestionInputParam;
import com.chemisbox.output.LoadAskQuestionOutputParam;

@Service
@Transactional
public class LoadAskQuestionBusiness
		extends
		ChemisboxBusiness<LoadAskQuestionInputParam, LoadAskQuestionOutputParam> {

	private AnswerDAO answerDao;

	@Override
	public LoadAskQuestionOutputParam execute(LoadAskQuestionInputParam inParam)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnswerDAO getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDAO answerDao) {
		this.answerDao = answerDao;
	}

}
