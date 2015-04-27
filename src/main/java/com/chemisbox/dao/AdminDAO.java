package com.chemisbox.dao;

import com.chemisbox.entity.Admin;
import com.chemisbox.exception.ChemisboxException;

public interface AdminDAO {
	public Admin authenticate(String userName, String password) throws ChemisboxException;
	
	public boolean update(Admin admin) throws ChemisboxException;
}
