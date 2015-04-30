package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Question;

public class LoadForumModel extends ChemisboxModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Question> questionList;
	private int startIndex;

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
