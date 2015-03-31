package com.chemisbox.dao;

import com.chemisbox.entity.OxiReduceEquation;
import com.chemisbox.exception.ChemisboxException;

public interface OxiReduceEquationDAO {
	public Long add(OxiReduceEquation oxi) throws ChemisboxException;
	public Long update(OxiReduceEquation oxi) throws ChemisboxException;
	public OxiReduceEquation get(Long id) throws ChemisboxException;
	public Long delete(OxiReduceEquation oxi) throws ChemisboxException;
}
