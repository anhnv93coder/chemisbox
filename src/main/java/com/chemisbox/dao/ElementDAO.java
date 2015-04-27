package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Element;
import com.chemisbox.exception.ChemisboxException;

public interface ElementDAO {
	public List<Element> list(int startIndex, int pageSize)
			throws ChemisboxException;
	
	public List<Element> list() throws ChemisboxException ;
	
	public String add(Element c) throws ChemisboxException ;
	
	public String delete(Element c) throws ChemisboxException ;
	
	public String update(Element c) throws ChemisboxException ;
	
	public Element get(String notation) throws ChemisboxException ;
	
	public Long getCount() throws ChemisboxException;
	
	public List<Element> getByKeyWord(String keyWord)
			throws ChemisboxException; 
}