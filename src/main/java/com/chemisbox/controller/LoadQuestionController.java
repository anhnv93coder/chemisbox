package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chemisbox.business.LoadQuestionBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadQuestionInputParam;
import com.chemisbox.model.LoadQuestionModel;
import com.chemisbox.output.LoadQuestionOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class LoadQuestionController extends ChemisboxController<LoadQuestionBusiness, LoadQuestionModel> {

	@RequestMapping(value = {"/question/{index}"})
	public String doLoadQuestion(@PathVariable("index") String index, ModelMap map) throws ChemisboxException {
		this.model = new LoadQuestionModel();
		Integer questionId = ChemisboxUtilities.getIntegerInString(index);
		LoadQuestionInputParam inParam = new LoadQuestionInputParam();
		inParam.setQuestionId(questionId);
		LoadQuestionOutputParam outParam = this.business.execute(inParam);
		if(ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
			this.model.setQuestion(outParam.getQuestion());
			this.model.setAnswerList(outParam.getAnswerList());
		}else{
			this.model.setErrorMessage(outParam.getErrorMessage());
		}
		map.put("loadQuestionModel", this.model);
		return "viewQuestion";
	}
	
	@Override
	public LoadQuestionModel execute(LoadQuestionModel model)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
