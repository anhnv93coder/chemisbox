package com.chemisbox.output;

import java.util.List;

import com.chemisbox.entity.Equation;

public class EquationManagementOutputParam extends ChemisboxOutputParam {
	private List<Equation> equationList;
	private long totalPages;
	private int businessType;
	private Equation equation;

	public Equation getEquation() {
		return equation;
	}

	public void setEquation(Equation equation) {
		this.equation = equation;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public List<Equation> getEquationList() {
		return equationList;
	}

	public void setEquationList(List<Equation> equationList) {
		this.equationList = equationList;
	}

}
