package com.chemisbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chemisbox.business.AddNewFeedbackBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AddNewFeedbackInputParam;
import com.chemisbox.model.AddNewFeedbackModel;
import com.chemisbox.output.AddNewFeedbackOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class AddNewFeedbackController extends
		ChemisboxController<AddNewFeedbackBusiness, AddNewFeedbackModel> {

	@Autowired
	private AddNewFeedbackBusiness addNewFeedbackBusiness;

	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	@Override
	public @ResponseBody AddNewFeedbackModel execute(@RequestBody AddNewFeedbackModel model)
			throws ChemisboxException {
		this.business = addNewFeedbackBusiness;
		
		if(model.getFeedback() == null){
			model.setErrorMessage("Feedback object is null");
			return model;
		}
		
		AddNewFeedbackInputParam inputParam = new AddNewFeedbackInputParam();
		inputParam.setFeedback(model.getFeedback());
		AddNewFeedbackOutputParam outputParam = this.business.execute(inputParam);
		if(!ChemisboxUtilities.isNullOrEmpty(outputParam.getErrorMessage())){
			model.setErrorMessage(outputParam.getErrorMessage());
		}
		
		return model;
	}

}
