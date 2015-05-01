package com.chemisbox.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.AnswerDAO;
import com.chemisbox.entity.Answer;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AnswerQuestionInputParam;
import com.chemisbox.output.AnswerQuestionOutputParam;

@Service
@Transactional
public class AnswerQuestionBusiness  extends ChemisboxBusiness<AnswerQuestionInputParam, AnswerQuestionOutputParam>{

	@Autowired
	private AnswerDAO answerDao;
	
	@Override
	public AnswerQuestionOutputParam execute(AnswerQuestionInputParam inParam)
			throws ChemisboxException {
		try {
			Question question = new Question();
			question.setQuestionId(inParam.getQuestionId());
			
			Answer answer = new Answer();
			answer.setContent(inParam.getContent());
			answer.setUser(inParam.getUser());
			answer.setQuestion(question);
			
			this.out = new AnswerQuestionOutputParam();
			
			Integer answerId = answerDao.add(answer);
			if(answerId == null){
				this.out.setErrorMessage("Them cau hoi khong thanh cong. Lien he voi admin.");
			}
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setAnswerDao(AnswerDAO answerDao) {
		this.answerDao = answerDao;
	}

}
