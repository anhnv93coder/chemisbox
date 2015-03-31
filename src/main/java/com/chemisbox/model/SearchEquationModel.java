package com.chemisbox.model;

import java.io.Serializable;
import java.util.List;

import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.Element;
import com.chemisbox.entity.Equation;

public class SearchEquationModel extends ChemisboxModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2326544438988900072L;
	private Element element;
	private Chemical chemical;
	private List<Equation> equationList;
	private String keyWord;

	public List<Equation> getEquationList() {
		return equationList;
	}

	public void setEquationList(List<Equation> equationList) {
		this.equationList = equationList;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

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

}
