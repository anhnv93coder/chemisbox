package com.chemisbox.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.UserDAO;
import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.RegisterUserInputParam;
import com.chemisbox.output.RegisterUserOutputParam;

@Service
@Transactional
public class RegisterUserBusiness extends
		ChemisboxBusiness<RegisterUserInputParam, RegisterUserOutputParam> {

	@Autowired
	private UserDAO userDao;

	@Override
	public RegisterUserOutputParam execute(RegisterUserInputParam inParam)
			throws ChemisboxException {
		try {
			this.out = new RegisterUserOutputParam();
			User user = userDao.get(inParam.getUser().getEmail());
			if(user != null){
				this.out.setErrorMessage("Email đã đăng ký.");
				return this.out;
			}
			
			if(!userDao.register(inParam.getUser())){
				this.out.setErrorMessage("Dang ky khong thanh cong.");
			}
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage("Co loi xay ra. Vui long lien he voi Administrator.");
		}
		return this.out;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
