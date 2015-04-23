package com.chemisbox.model;

import java.util.List;

public class DefaultModel extends ChemisboxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -127925225777852357L;

	private List<String> suggestList;

	public List<String> getSuggestList() {
		return suggestList;
	}

	public void setSuggestList(List<String> suggestList) {
		this.suggestList = suggestList;
	}

}
