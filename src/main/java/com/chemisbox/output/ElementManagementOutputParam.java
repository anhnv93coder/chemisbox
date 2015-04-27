package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Element;

public class ElementManagementOutputParam extends ChemisboxOutputParam {
	private List<Element> elementList;
	private Element element;
	private long totalPages;

	public List<Element> getElementList() {
		return elementList;
	}

	public void setElementList(List<Element> elementList) {
		this.elementList = elementList;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

}
