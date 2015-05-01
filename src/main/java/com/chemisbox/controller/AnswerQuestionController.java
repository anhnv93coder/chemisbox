package com.chemisbox.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.AnswerQuestionBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.entity.User;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AnswerQuestionInputParam;
import com.chemisbox.model.AnswerQuestionModel;
import com.chemisbox.output.AnswerQuestionOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("userObject")
public class AnswerQuestionController extends
		ChemisboxController<AnswerQuestionBusiness, AnswerQuestionModel> {

	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public @ResponseBody AnswerQuestionModel doAnswer(
			@RequestBody AnswerQuestionModel model, ModelMap map,
			HttpServletRequest servletRequest) throws ChemisboxException {
		this.model = new AnswerQuestionModel();

		if (!map.containsAttribute("userObject")) {
			this.model.setErrorMessage(ChemisboxConstant.CB_001);
			return this.model;
		}

		if (ChemisboxUtilities.isNullOrEmpty(model.getContent())) {
			this.model.setErrorMessage("Noi dung dang rong");
			return this.model;
		}

		User user = (User) servletRequest.getSession().getAttribute(
				"userObject");

		AnswerQuestionInputParam inParam = new AnswerQuestionInputParam();
		inParam.setContent(model.getContent().trim());
		inParam.setUser(user);
		inParam.setQuestionId(model.getQuestionId());

		AnswerQuestionOutputParam outParam = this.business.execute(inParam);
		if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
			this.model.setErrorMessage(outParam.getErrorMessage());
		}

		return this.model;
	}

	@Override
	public @ResponseBody AnswerQuestionModel execute(
			@RequestBody AnswerQuestionModel model, ModelMap map)
			throws ChemisboxException {
		return null;
	}

}
