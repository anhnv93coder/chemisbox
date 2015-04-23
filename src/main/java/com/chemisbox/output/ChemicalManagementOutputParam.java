package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Chemical;

public class ChemicalManagementOutputParam extends ChemisboxOutputParam {
	private List<Chemical> chemicalList;
	private Chemical chemical;
	private long totalPages;

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public Chemical getChemical() {
		return chemical;
	}

	public void setChemical(Chemical chemical) {
		this.chemical = chemical;
	}

	public List<Chemical> getChemicalList() {
		return chemicalList;
	}

	public void setChemicalList(List<Chemical> chemicalList) {
		this.chemicalList = chemicalList;
	}

}
