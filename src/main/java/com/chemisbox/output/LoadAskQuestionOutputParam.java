package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Question;

public class LoadAskQuestionOutputParam extends ChemisboxOutputParam {
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

}
