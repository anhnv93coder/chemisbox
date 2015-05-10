package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadAskQuestionInputParam;
import com.chemisbox.output.LoadAskQuestionOutputParam;

@Service
@Transactional
public class LoadAskQuestionBusiness
		extends
		ChemisboxBusiness<LoadAskQuestionInputParam, LoadAskQuestionOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Override
	public LoadAskQuestionOutputParam execute(LoadAskQuestionInputParam inParam)
			throws ChemisboxException {
		this.out = new LoadAskQuestionOutputParam();
		List<Question> topQuestionList = null;
		List<Question> questionHaveNotAnswer = null;
		try {
			topQuestionList = questionDao.selectViewTopQuestion(0,
					ChemisboxConstant.TOP_QUESTION_NUMBER_IN_PAGE);
			questionHaveNotAnswer = questionDao.selectQuestionHaveNotAnswer(0,
					ChemisboxConstant.TOP_QUESTION_NUMBER_IN_PAGE);
			this.out.setTopQuestionList(topQuestionList);
			this.out.setQuestionHaveNotAnswerList(questionHaveNotAnswer);
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

}
