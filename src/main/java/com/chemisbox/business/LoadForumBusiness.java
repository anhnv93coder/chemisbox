package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.AnswerDAO;
import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadForumInputParam;
import com.chemisbox.output.LoadForumOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class LoadForumBusiness extends
		ChemisboxBusiness<LoadForumInputParam, LoadForumOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private AnswerDAO answerDao;

	@Override
	public LoadForumOutputParam execute(LoadForumInputParam inParam)
			throws ChemisboxException {
		this.out = new LoadForumOutputParam();
		List<Question> questionList = null;
		List<Question> topQuestionList = null;
		List<Question> questionHaveNotAnswer = null;
		try {
			questionList = questionDao.selectLastestQuestion(
					inParam.getStartIndex(), inParam.getPageSize());
			topQuestionList = questionDao.selectViewTopQuestion(0, ChemisboxConstant.TOP_QUESTION_NUMBER_IN_PAGE);
			questionHaveNotAnswer = questionDao.selectQuestionHaveNotAnswer(0, ChemisboxConstant.TOP_QUESTION_NUMBER_IN_PAGE);
			for (int i = 0; i < questionList.size(); i++) {
				Question questionObj = questionList.get(i);
				Long answerCounter = answerDao.getCountByQuestion(questionObj.getQuestionId());
				questionObj.setAnswerCounter(answerCounter);
			}
					
			if (ChemisboxUtilities.isNullOrEmpty(questionList)) {
				this.out.setErrorMessage("Không có dữ liệu");
			} else {
				this.out.setQuestionList(questionList);
				this.out.setTopQuestionList(topQuestionList);
				this.out.setQuestionHaveNotAnswerList(questionHaveNotAnswer);
			}
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

	public void setAnswerDao(AnswerDAO answerDao) {
		this.answerDao = answerDao;
	}

}
