package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Chemical;

public class ChemicalManagementModel extends ChemisboxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Chemical chemical;
	private List<Chemical> chemicalList;
	private long totalPage;
	private Long chemicalId;
	private int currentPage;
	private String keyWord;
	private String currentUrl;

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

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

	public Long getChemicalId() {
		return chemicalId;
	}

	public void setChemicalId(Long chemicalId) {
		this.chemicalId = chemicalId;
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
