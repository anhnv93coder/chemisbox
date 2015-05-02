package com.chemisbox.dao;

import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;

public interface UserDAO {

	public boolean register(User user) throws ChemisboxException;

	public String update(User user) throws ChemisboxException;

	public User authenticate(String email, String password) throws ChemisboxException;
	
	public User get(String email) throws ChemisboxException;
	
	public Long getCount() throws ChemisboxException;
}
