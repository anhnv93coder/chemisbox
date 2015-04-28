package com.chemisbox.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.chemisbox.exception.ChemisboxException;

public abstract class ChemisboxController<T, V> {
	@Autowired
	protected T business;
	protected V model;

	public abstract V execute(V model) throws ChemisboxException;

	public void setBusiness(T business) {
		this.business = business;
	}

	public T getBusiness() {
		return business;
	}

}
