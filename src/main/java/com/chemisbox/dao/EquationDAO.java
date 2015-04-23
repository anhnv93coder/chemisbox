package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Equation;
import com.chemisbox.exception.ChemisboxException;

public interface EquationDAO {
	public List<Equation> selectByChemical(String chemical) throws ChemisboxException;
	public List<Equation> selectByChemical(String chemical, int typeOf) throws ChemisboxException;
	public List<Equation> selectByChemicals(String leftChemical, String rightChemical) throws ChemisboxException;
	public List<Equation> selectByChemicals(String chemical1, String chemical2, int typeOf) throws ChemisboxException;
	public List<Equation> selectByChemicals(String chemical1, String chemical2, String chemical3, int typeOf) throws ChemisboxException;
	public List<Equation> list(int startIndex, int pageSize) throws ChemisboxException;
	public Long add(Equation e) throws ChemisboxException;
	public boolean delete(Equation e) throws ChemisboxException;
	public Long update(Equation e) throws ChemisboxException;
	public Equation get(Long id) throws ChemisboxException;
	public Long getCount();
}
