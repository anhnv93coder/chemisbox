package com.chemisbox.model;

import com.chemisbox.entity.Feedback;

public class AddNewFeedbackModel extends ChemisboxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Feedback feedback;

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

}
