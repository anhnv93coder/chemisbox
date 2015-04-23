package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.Element;
import com.chemisbox.entity.Equation;

@SuppressWarnings("serial")
public class SearchEquationModel extends ChemisboxModel{

	private Element element;
	private Chemical chemical;
	private List<Equation> equationList;
	private List<Integer> indexList;
	private String keyWord;

	public SearchEquationModel() {

	}

	public List<Integer> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<Integer> indexList) {
		this.indexList = indexList;
	}

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
