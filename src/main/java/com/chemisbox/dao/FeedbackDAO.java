package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Feedback;
import com.chemisbox.exception.ChemisboxException;

public interface FeedbackDAO {
	
	public Integer add(Feedback feedback) throws ChemisboxException;

	public boolean delete(Feedback feedback) throws ChemisboxException;

	public Feedback get(Integer id) throws ChemisboxException;

	public Integer getCount() throws ChemisboxException;
	
	public List<Feedback> list(int startIndex, int pageSize) throws ChemisboxException;
}