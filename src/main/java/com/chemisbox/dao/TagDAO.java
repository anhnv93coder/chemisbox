package com.chemisbox.dao;

import java.util.List;

import com.chemisbox.entity.Tag;
import com.chemisbox.exception.ChemisboxException;

public interface TagDAO {
	
	public List<Tag> selectByQuestion() throws ChemisboxException;

	public Integer add(Tag tag) throws ChemisboxException;

	public Integer update(Tag tag) throws ChemisboxException;

	public Integer delete(Tag tag) throws ChemisboxException;

	public Tag get(Integer id) throws ChemisboxException;
}
