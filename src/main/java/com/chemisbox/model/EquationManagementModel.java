package com.chemisbox.model;

import java.util.List;

import com.chemisbox.entity.Equation;

public class EquationManagementModel extends ChemisboxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long equationId;
	private Equation equation;
	private List<Equation> equationList;
	private long totalPage;
	private int currentPage;

	public List<Equation> getEquationList() {
		return equationList;
	}

	public void setEquationList(List<Equation> equationList) {
		this.equationList = equationList;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Long getEquationId() {
		return equationId;
	}

	public void setEquationId(Long equationId) {
		this.equationId = equationId;
	}

	public Equation getEquation() {
		return equation;
	}

	public void setEquation(Equation equation) {
		this.equation = equation;
	}

}
