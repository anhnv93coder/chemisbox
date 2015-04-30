package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;

public interface QuestionDAO {
	
	public List<Question> selectLastestQuestion(int startIndex, int pageSize) throws ChemisboxException;
	
	public List<Question> selectQuestionByUser(String email, int startIndex, int pageSize) throws ChemisboxException;
	
	public List<Question> selectHotQuestion(int startIndex, int pageSize) throws ChemisboxException;
	
	public Integer add(Question question);
	
	public Integer update(Question question);
	
	public boolean delete(Question question);
	
	public Question get(Integer id);
}
