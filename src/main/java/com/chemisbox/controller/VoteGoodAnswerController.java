package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.VoteGoodAnswerBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.VoteGoodAnswerInputParam;
import com.chemisbox.model.VoteGoodAnswerModel;
import com.chemisbox.output.VoteGoodAnswerOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("userObject")
public class VoteGoodAnswerController extends ChemisboxController<VoteGoodAnswerBusiness, VoteGoodAnswerModel> {

	@RequestMapping(value = "/answer/vote", method = RequestMethod.POST)
	@Override
	public @ResponseBody VoteGoodAnswerModel execute(@RequestBody VoteGoodAnswerModel model, ModelMap map)
			throws ChemisboxException {
		this.model = new VoteGoodAnswerModel();
		if(!map.containsAttribute("userObject")){
			this.model.setErrorMessage(ChemisboxConstant.CB_001);
			return this.model;
		}

		if(model == null || model.getQuestionId() == null || model.getAnswerId() == null){
			this.model.setErrorMessage("Invalid parameter");
			return this.model;
		}
		
		VoteGoodAnswerInputParam inParam = new VoteGoodAnswerInputParam();
		inParam.setAnswerId(model.getAnswerId());
		inParam.setQuestionId(model.getQuestionId());
		
		VoteGoodAnswerOutputParam outParam = this.business.execute(inParam);
		if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
			this.model.setErrorMessage(outParam.getErrorMessage());
		}
		
		return this.model;
	}

}
