package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.chemisbox.business.LoginAdminBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoginAdminInputParam;
import com.chemisbox.model.LoginAdminModel;
import com.chemisbox.output.LoginAdminOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;


@Controller
@SessionAttributes("adminObject")
public class LoginAdminController extends ChemisboxController<LoginAdminBusiness, LoginAdminModel>{
	
	@RequestMapping(value = {"/admin", "/admin/"})
	public String getIndex(ModelMap map){
		return "login";
	}
		
	@RequestMapping(value = {"/admin/logout"})
	public String doLogout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "login";
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public @ResponseBody LoginAdminModel doLogin(@RequestBody LoginAdminModel model, ModelMap map)  throws ChemisboxException {
		
			this.model = new LoginAdminModel();
			
			if(model == null){
				this.model.setErrorMessage("Model is NULL");
				return this.model;
			}
			
			if(ChemisboxUtilities.isNullOrEmpty(model.getUserName()) || ChemisboxUtilities.isNullOrEmpty(model.getPassword())){
				this.model.setErrorMessage("User name or password is not NULL");
				return this.model;
			}
			
			LoginAdminInputParam inParam = new LoginAdminInputParam();
			inParam.setUserName(model.getUserName().trim());
			inParam.setPassword(model.getPassword().trim());
			
			LoginAdminOutputParam outParam = this.business.execute(inParam);
			if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
				this.model.setErrorMessage(outParam.getErrorMessage());
				return this.model;
			}	
			map.put("adminObject", outParam.getAdmin());
			return this.model;
		
	}
	
	
	@Override
	public LoginAdminModel execute(LoginAdminModel model, ModelMap map) throws ChemisboxException {
		
		this.model = new LoginAdminModel();
		
		if(model == null){
			this.model.setErrorMessage("Model is NULL");
			return this.model;
		}
		
		if(ChemisboxUtilities.isNullOrEmpty(model.getUserName()) || ChemisboxUtilities.isNullOrEmpty(model.getPassword())){
			this.model.setErrorMessage("User name or password is not NULL");
			return this.model;
		}
		
		LoginAdminInputParam inParam = new LoginAdminInputParam();
		inParam.setUserName(model.getUserName().trim());
		inParam.setPassword(model.getPassword().trim());
		
		LoginAdminOutputParam outParam = this.business.execute(inParam);
		if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
			this.model.setErrorMessage(outParam.getErrorMessage());
			return this.model;
		}	
		
		return this.model;
	}
	
}
