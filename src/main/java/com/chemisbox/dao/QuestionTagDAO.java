package com.chemisbox.dao;

import com.chemisbox.entity.QuestionTag;
import com.chemisbox.exception.ChemisboxException;


public interface QuestionTagDAO {
	
	public Integer add(QuestionTag questionTag) throws ChemisboxException;
	
	public Integer delete(QuestionTag questionTag) throws ChemisboxException;
}
