package com.chemisbox.model;

import java.io.Serializable;

public abstract class ChemisboxModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7938978307749617767L;
	private String errorMessage;

	public ChemisboxModel() {

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
