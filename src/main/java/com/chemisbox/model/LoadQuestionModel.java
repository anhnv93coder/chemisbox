package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Answer;
import com.chemisbox.entity.Question;

public class LoadQuestionModel extends ChemisboxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Question question;

	private List<Answer> answerList;

	private long answerCount;

	private List<Question> topQuestionList;
	private List<Question> questionHaveNotAnswerList;

	public List<Question> getTopQuestionList() {
		return topQuestionList;
	}

	public void setTopQuestionList(List<Question> topQuestionList) {
		this.topQuestionList = topQuestionList;
	}

	public List<Question> getQuestionHaveNotAnswerList() {
		return questionHaveNotAnswerList;
	}

	public void setQuestionHaveNotAnswerList(
			List<Question> questionHaveNotAnswerList) {
		this.questionHaveNotAnswerList = questionHaveNotAnswerList;
	}

	public long getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
