package com.chemisbox.input;

import com.chemisbox.entity.Chemical;

public class ChemicalManagementInputParam extends ChemisboxInputParam {
	private int startIndex;
	private int pageSize;
	private Chemical chemical;
	private int businessType;
	private Long chemicalId;

	public Long getChemicalId() {
		return chemicalId;
	}

	public void setChemicalId(Long chemicalId) {
		this.chemicalId = chemicalId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public Chemical getChemical() {
		return chemical;
	}

	public void setChemical(Chemical chemical) {
		this.chemical = chemical;
	}

}
