package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Chemical;
import com.chemisbox.exception.ChemisboxException;

public interface ChemicalDAO {
	public List<Chemical> list(int startIndex, int pageSize)
			throws ChemisboxException;

	public List<Chemical> list(String formula) throws ChemisboxException;

	public Long add(Chemical c) throws ChemisboxException;

	public boolean delete(Chemical c) throws ChemisboxException;

	public Long update(Chemical c) throws ChemisboxException;

	public Chemical get(Long id) throws ChemisboxException;

	public Long get(String formula) throws ChemisboxException;

	public Long getCount() throws ChemisboxException;
}