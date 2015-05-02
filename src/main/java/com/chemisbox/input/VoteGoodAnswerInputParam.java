package com.chemisbox.input;

public class VoteGoodAnswerInputParam extends ChemisboxInputParam {
	private Integer questionId;
	private Integer answerId;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
}
