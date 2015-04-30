package com.chemisbox.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.chemisbox.dao.UserDAO;
import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoginUserInputParam;
import com.chemisbox.output.LoginUserOutputParam;

public class LoginUserBusiness extends
		ChemisboxBusiness<LoginUserInputParam, LoginUserOutputParam> {

	@Autowired
	private UserDAO userDao;

	@Override
	public LoginUserOutputParam execute(LoginUserInputParam inParam)
			throws ChemisboxException {
		this.out = new LoginUserOutputParam();
		User user = null;
		try {
			user = userDao.authenticate(inParam.getEmail(), inParam.getPassword());
			if(user == null){
				this.out.setErrorMessage("Tai khoan hoac mat khau khong dung");
				return this.out;
			}
			this.out.setUser(user);
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
