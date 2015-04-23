package com.chemisbox.input;

import com.chemisbox.entity.Feedback;

public class AddNewFeedbackInputParam extends ChemisboxInputParam {
	private Feedback feedback;

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

}
