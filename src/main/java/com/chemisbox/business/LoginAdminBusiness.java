package com.chemisbox.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.AdminDAO;
import com.chemisbox.entity.Admin;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoginAdminInputParam;
import com.chemisbox.output.LoginAdminOutputParam;

@Service
@Transactional
public class LoginAdminBusiness extends
		ChemisboxBusiness<LoginAdminInputParam, LoginAdminOutputParam> {

	@Autowired
	private AdminDAO adminDao;

	@Override
	public LoginAdminOutputParam execute(LoginAdminInputParam inParam)
			throws ChemisboxException {
		this.out = new LoginAdminOutputParam();
		Admin admin = null;
		try {
			admin = adminDao.authenticate(inParam.getUserName(), inParam.getPassword());
			if(admin == null){
				this.out.setErrorMessage("User name or password is invalid");
				return this.out;
			}
			this.out.setAdmin(admin);
		} catch (Exception e) {
			this.out.setErrorCode(e.getMessage());
		}
		return this.out;
	}

	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

}
