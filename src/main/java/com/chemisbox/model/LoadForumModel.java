package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Question;

public class LoadForumModel extends ChemisboxModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Question> questionList;
	private List<Question> topQuestionList;
	private List<Question> questionHaveNotAnswerList;
	private int startIndex;
	private long answerCount;

	public List<Question> getQuestionHaveNotAnswerList() {
		return questionHaveNotAnswerList;
	}

	public void setQuestionHaveNotAnswerList(
			List<Question> questionHaveNotAnswerList) {
		this.questionHaveNotAnswerList = questionHaveNotAnswerList;
	}

	public List<Question> getTopQuestionList() {
		return topQuestionList;
	}

	public void setTopQuestionList(List<Question> topQuestionList) {
		this.topQuestionList = topQuestionList;
	}

	public long getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

}
