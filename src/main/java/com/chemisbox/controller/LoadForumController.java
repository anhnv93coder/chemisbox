package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chemisbox.business.LoadForumBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadForumInputParam;
import com.chemisbox.model.LoadForumModel;
import com.chemisbox.output.LoadForumOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class LoadForumController extends
		ChemisboxController<LoadForumBusiness, LoadForumModel> {

	@RequestMapping(value = { "/forum", "/forum/" })
	public String doLoadForum(ModelMap map) throws ChemisboxException {
		LoadForumInputParam inParam = new LoadForumInputParam();
		inParam.setStartIndex(0);
		inParam.setEmail("anhnv@a.com");
		LoadForumOutputParam outParam = this.business.execute(inParam);
		this.model = new LoadForumModel();
		if (ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
			this.model.setQuestionList(outParam.getQuestionList());
		} else {
			this.model.setErrorMessage(outParam.getErrorMessage());
		}
		map.put("forumModel", this.model);
		return "forum";
	}

	

	@RequestMapping(value = { "/ask", "/ask/" })
	public String doLoadAskQuestion() throws ChemisboxException {

		return "askQuestion";
	}

	@Override
	public LoadForumModel execute(LoadForumModel model)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}
}