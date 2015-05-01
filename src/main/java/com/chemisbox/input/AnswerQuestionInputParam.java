package com.chemisbox.input;

import com.chemisbox.entity.User;

public class AnswerQuestionInputParam extends ChemisboxInputParam {

	private String content;
	private User user;
	private Integer questionId;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
