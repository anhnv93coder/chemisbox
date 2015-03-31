package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.ChemistryEquation;

public interface ChemistryEquationDAO {
	public boolean add(ChemistryEquation chemistryEquation);
	public boolean delete(ChemistryEquation chemistryEquation);
	public List<ChemistryEquation> list();
}
