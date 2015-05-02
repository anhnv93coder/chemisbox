package com.chemisbox.output;

public class ShowDashboardOutputParam extends ChemisboxOutputParam {
	private Long equationCounter;
	private Long chemicalCounter;
	private Long elementCounter;
	private Long questionCounter;
	private Long questionIsNotApprovedCounter;
	private Long userCounter;

	public Long getEquationCounter() {
		return equationCounter;
	}

	public void setEquationCounter(Long equationCounter) {
		this.equationCounter = equationCounter;
	}

	public Long getChemicalCounter() {
		return chemicalCounter;
	}

	public void setChemicalCounter(Long chemicalCounter) {
		this.chemicalCounter = chemicalCounter;
	}

	public Long getElementCounter() {
		return elementCounter;
	}

	public void setElementCounter(Long elementCounter) {
		this.elementCounter = elementCounter;
	}

	public Long getQuestionCounter() {
		return questionCounter;
	}

	public void setQuestionCounter(Long questionCounter) {
		this.questionCounter = questionCounter;
	}

	public Long getQuestionIsNotApprovedCounter() {
		return questionIsNotApprovedCounter;
	}

	public void setQuestionIsNotApprovedCounter(
			Long questionIsNotApprovedCounter) {
		this.questionIsNotApprovedCounter = questionIsNotApprovedCounter;
	}

	public Long getUserCounter() {
		return userCounter;
	}

	public void setUserCounter(Long userCounter) {
		this.userCounter = userCounter;
	}
}
