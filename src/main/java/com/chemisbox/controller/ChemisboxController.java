package com.chemisbox.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.chemisbox.exception.ChemisboxException;

public abstract class ChemisboxController<T, V> {
	@Autowired
	protected T business;
	protected V model;

	public abstract V execute() throws ChemisboxException;
}
