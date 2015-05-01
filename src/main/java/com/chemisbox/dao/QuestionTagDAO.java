package com.chemisbox.dao;

import com.chemisbox.entity.QuestionTag;
import com.chemisbox.exception.ChemisboxException;


public interface QuestionTagDAO {
	
	public boolean add(QuestionTag questionTag) throws ChemisboxException;
	
	public boolean delete(QuestionTag questionTag) throws ChemisboxException;
}
