package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Answer;
import com.chemisbox.exception.ChemisboxException;

public interface AnswerDAO {
	public List<Answer> selectByQuestion(Integer questionId) throws ChemisboxException;
	
	public Integer add(Answer answer) throws ChemisboxException;
	
	public Integer update(Answer answer) throws ChemisboxException;
	
	public boolean delete(Answer answer) throws ChemisboxException;
	
	public Answer get(Integer id) throws ChemisboxException;
}
