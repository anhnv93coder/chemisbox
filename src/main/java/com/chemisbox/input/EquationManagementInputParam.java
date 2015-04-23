package com.chemisbox.input;

import com.chemisbox.entity.Equation;

public class EquationManagementInputParam extends ChemisboxInputParam {
	private Equation equation;
	private int businessType;
	private int startIndex;
	private int pageSize;
	private long equationId;

	public long getEquationId() {
		return equationId;
	}

	public void setEquationId(long equationId) {
		this.equationId = equationId;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public Equation getEquation() {
		return equation;
	}

	public void setEquation(Equation equation) {
		this.equation = equation;
	}

}
