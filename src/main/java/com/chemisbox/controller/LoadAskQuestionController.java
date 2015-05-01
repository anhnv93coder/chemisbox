package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.LoadAskQuestionBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.model.LoadAskQuestionModel;

@Controller
@SessionAttributes("userObject")
public class LoadAskQuestionController extends
		ChemisboxController<LoadAskQuestionBusiness, LoadAskQuestionModel> {

	@RequestMapping(value = { "/ask", "/ask/" })
	public String doLoadAskQuestion(ModelMap map) throws ChemisboxException {
		if (!map.containsAttribute("userObject")) {
			return "login4Forum";
		}
		return "askQuestion";
	}

	@Override
	public LoadAskQuestionModel execute(LoadAskQuestionModel model, ModelMap map)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
