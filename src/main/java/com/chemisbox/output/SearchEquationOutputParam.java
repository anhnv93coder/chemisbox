package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.Element;
import com.chemisbox.entity.Equation;

public class SearchEquationOutputParam extends ChemisboxOutputParam {

	private Element element;
	private Chemical chemical;
	private List<Equation> equationList;

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Chemical getChemical() {
		return chemical;
	}

	public void setChemical(Chemical chemical) {
		this.chemical = chemical;
	}

	public List<Equation> getEquationList() {
		return equationList;
	}

	public void setEquationList(List<Equation> equationList) {
		this.equationList = equationList;
	}

}
