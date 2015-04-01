package com.chemisbox.model;

import java.io.Serializable;

public abstract class ChemisboxModel implements Serializable {
	/**
	 * 
	 */
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
