package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;

public interface QuestionDAO {
	
	public List<Question> selectLastestQuestion(int startIndex, int pageSize) throws ChemisboxException;
	
	public List<Question> selectQuestionByUser(String email, int startIndex, int pageSize) throws ChemisboxException;
	
	public List<Question> selectHotQuestion(int startIndex, int pageSize) throws ChemisboxException;
	
	public Integer add(Question question) throws ChemisboxException;
	
	public Integer update(Question question) throws ChemisboxException;
	
	public boolean delete(Question question) throws ChemisboxException;
	
	public Question get(Integer id) throws ChemisboxException;
}
