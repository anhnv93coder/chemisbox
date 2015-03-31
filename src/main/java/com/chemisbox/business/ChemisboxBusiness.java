package com.chemisbox.business;

import com.chemisbox.exception.ChemisboxException;

public abstract class ChemisboxBusiness<T, V> {
	protected V out;
	
	public abstract V execute(T inParam) throws ChemisboxException;
	
}
