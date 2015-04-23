package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.ChemistryEquation;

public interface ChemistryEquationDAO {
	public boolean add(ChemistryEquation chemistryEquation);
	public boolean delete(Long equationId);
	public List<ChemistryEquation> list();
}
