package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.chemisbox.business.LoginUserBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoginUserInputParam;
import com.chemisbox.model.LoginUserModel;
import com.chemisbox.output.LoginUserOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("userObject")
public class LoginUserController extends ChemisboxController<LoginUserBusiness, LoginUserModel> {

	@RequestMapping(value = "/login")
	public String doLoadLoginForm(){
		return "login4Forum";
	}
	
	@RequestMapping(value = "/logout")
	public String doLogout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "login4Forum";
	}
	
	@RequestMapping(value = "/doAuth", method = RequestMethod.POST)
	public @ResponseBody LoginUserModel doLogin(@RequestBody LoginUserModel userModel, ModelMap map) throws ChemisboxException{
		this.model = new LoginUserModel();
		
		if(userModel == null){
			this.model.setErrorMessage("Thong tin dang nhap de trong");
			return this.model;
		}
		
		LoginUserInputParam inParam = new LoginUserInputParam();
		inParam.setEmail(userModel.getEmail());
		inParam.setPassword(userModel.getPassword());
		LoginUserOutputParam outParam = this.business.execute(inParam);
		if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
			this.model.setEmail(outParam.getErrorMessage());
			return this.model;
		}
		map.put("userObject", outParam.getUser());
		return this.model;
	}
	
	@Override
	public LoginUserModel execute(LoginUserModel model, ModelMap map)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
