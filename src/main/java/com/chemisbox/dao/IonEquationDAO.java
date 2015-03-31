package com.chemisbox.dao;

import com.chemisbox.entity.IonEquation;
import com.chemisbox.exception.ChemisboxException;

public interface IonEquationDAO {
	public Long add(IonEquation ion) throws ChemisboxException;
	public Long update(IonEquation ion) throws ChemisboxException;
	public IonEquation get(Long id) throws ChemisboxException;
	public Long delete(IonEquation ion) throws ChemisboxException;
}
