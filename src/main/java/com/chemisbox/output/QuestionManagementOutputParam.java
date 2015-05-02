package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Question;

public class QuestionManagementOutputParam extends ChemisboxOutputParam {
	private List<Question> questionList;
	private Question question;
	private int totalPages;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

}
