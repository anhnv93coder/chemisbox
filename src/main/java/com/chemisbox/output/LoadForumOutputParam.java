package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Question;

public class LoadForumOutputParam extends ChemisboxOutputParam {
	private List<Question> questionList;
	

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

}
