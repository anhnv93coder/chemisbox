package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Equation;

public class SearchEquationOutputParam extends ChemisboxOutputParam {
	private List<Equation> equationList;

	public List<Equation> getEquationList() {
		return equationList;
	}

	public void setEquationList(List<Equation> equationList) {
		this.equationList = equationList;
	}

}
