package com.chemisbox.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.AddQuestionBusiness;
import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AddQuestionInputParam;
import com.chemisbox.model.AddQuestionModel;
import com.chemisbox.output.AddQuestionOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("userObject")
public class AddQuestionController extends
		ChemisboxController<AddQuestionBusiness, AddQuestionModel> {

	@RequestMapping(value = "/ask/add")
	public @ResponseBody AddQuestionModel doAddQuestion(@RequestBody AddQuestionModel model,
			HttpServletRequest request, ModelMap map)
			throws ChemisboxException {
		AddQuestionInputParam inParam = new AddQuestionInputParam();
		this.model = new AddQuestionModel();
		if (!map.containsAttribute("userObject")) {
			throw new ChemisboxException(
					"User must be login before add question");
		}
		User userObject = (User) request.getSession().getAttribute("userObject");
		inParam.setUser(userObject);
		inParam.setTitle(model.getTitle());
		inParam.setContent(model.getContent());
		inParam.setTagName(model.getTagName());
		AddQuestionOutputParam outParam = this.business.execute(inParam);

		if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
			this.model.setErrorMessage(outParam.getErrorMessage());
		}

		return this.model;
	}

	@Override
	public AddQuestionModel execute(AddQuestionModel model, ModelMap map)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
