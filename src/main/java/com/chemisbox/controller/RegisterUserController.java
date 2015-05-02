package com.chemisbox.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.RegisterUserBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.RegisterUserInputParam;
import com.chemisbox.model.RegisterUserModel;
import com.chemisbox.output.RegisterUserOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("userObject")
public class RegisterUserController extends
		ChemisboxController<RegisterUserBusiness, RegisterUserModel> {

	@RequestMapping(value = "/loadRegister")
	public String doLoadRegisterScreen(ModelMap map) {
		if (map.containsAttribute("userObject")) {
			return "redirect: /forum";
		}
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Override
	public @ResponseBody RegisterUserModel execute(
			@RequestBody RegisterUserModel model, ModelMap map)
			throws ChemisboxException {
		this.model = new RegisterUserModel();
		try {
			if (map.containsAttribute("userObject")) {
				this.model.setErrorMessage(ChemisboxConstant.CB_001);
				return this.model;
			}

			if (model == null) {
				this.model.setErrorMessage("Xuất hiện lỗi. Vui lòng liên hệ với quản trị.");
				return this.model;
			}

			if (ChemisboxUtilities.isNullOrEmpty(model.getAddress()) 
					|| ChemisboxUtilities.isNullOrEmpty(model.getDateOfBirth())
					|| ChemisboxUtilities.isNullOrEmpty(model.getEmail()) 
					|| ChemisboxUtilities.isNullOrEmpty(model.getFullName()) 
					|| ChemisboxUtilities.isNullOrEmpty(model.getPassword())
					|| ChemisboxUtilities.isValidEmail(model.getPhoneNumber())) {
				this.model
				.setErrorMessage("Vui lòng nhập đầy đủ thông tin.");
				return this.model;
			}

			if(!ChemisboxUtilities.isValidEmail(model.getEmail())){
				this.model
				.setErrorMessage("Định dạng email không đúng.");
				return this.model;
			}
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			User user = new User();
			user.setAddress(model.getAddress());
			user.setDateOfBirth(simpleDateFormat.parse(model.getDateOfBirth()));
			user.setEmail(model.getEmail());
			user.setFullName(model.getFullName());
			user.setPassword(model.getPassword());
			user.setPhoneNumber(model.getPhoneNumber());
			
			
			RegisterUserInputParam inParam = new RegisterUserInputParam();
			inParam.setUser(user);
			RegisterUserOutputParam outParam = this.business.execute(inParam);
			
			if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
			return this.model;
		} catch (Exception e) {
			this.model.setErrorMessage("Xuất hiện lỗi. Vui lòng liên hệ với quản trị.");
		}
		return this.model;
	}

}
