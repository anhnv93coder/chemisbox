package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.AnswerDAO;
import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.entity.Answer;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadQuestionInputParam;
import com.chemisbox.output.LoadQuestionOutputParam;

@Service
@Transactional
public class LoadQuestionBusiness extends
		ChemisboxBusiness<LoadQuestionInputParam, LoadQuestionOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private AnswerDAO answerDao;

	@Override
	public LoadQuestionOutputParam execute(LoadQuestionInputParam inParam)
			throws ChemisboxException {
		Question question = null;
		List<Answer> answerList = null;
		this.out = new LoadQuestionOutputParam();
		try {
			question = questionDao.get(inParam.getQuestionId());
			
			answerList = answerDao.selectByQuestion(inParam.getQuestionId());
			
			if(question == null){
				this.out.setErrorMessage("Question not exist");
				return this.out;
			}
			
			question.setViews(question.getViews() + 1);
			
			questionDao.update(question);
			
			this.out.setQuestion(question);
			this.out.setAnswerList(answerList);
			
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
