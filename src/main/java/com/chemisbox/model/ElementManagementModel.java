package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Element;

public class ElementManagementModel extends ChemisboxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Element element;
	private List<Element> elementList;
	private long totalPage;
	private String notation;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public Element getChemical() {
		return element;
	}

	public void setChemical(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public List<Element> getElementList() {
		return elementList;
	}

	public void setElementList(List<Element> elementList) {
		this.elementList = elementList;
	}

	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

}
