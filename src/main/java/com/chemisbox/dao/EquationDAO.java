package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Equation;
import com.chemisbox.exception.ChemisboxException;

public interface EquationDAO {
	public List<Equation> selectByChemical(String chemical, int typeOf) throws ChemisboxException;
	public List<Equation> selectByChemicals(String leftChemical, String rightChemical) throws ChemisboxException;
	public Long add(Equation e) throws ChemisboxException;
	public Long delete(Equation e) throws ChemisboxException;
	public Long update(Equation e) throws ChemisboxException;
	public Equation get(Long id) throws ChemisboxException;
}
