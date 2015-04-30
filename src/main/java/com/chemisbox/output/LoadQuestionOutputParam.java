package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Answer;
import com.chemisbox.entity.Question;

public class LoadQuestionOutputParam extends ChemisboxOutputParam {
	private Question question;
	private List<Answer> answerList;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

}
