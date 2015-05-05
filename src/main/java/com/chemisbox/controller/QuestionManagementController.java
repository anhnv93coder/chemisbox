package com.chemisbox.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.QuestionManagementBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.QuestionManagementInputParam;
import com.chemisbox.model.QuestionManagementModel;
import com.chemisbox.output.QuestionManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("adminObject")
public class QuestionManagementController extends ChemisboxController<QuestionManagementBusiness, QuestionManagementModel>{

	@RequestMapping(value = {"/admin/question", "/admin/question/"}, method = RequestMethod.GET)
	public String defaultAPI(ModelMap map) {
		this.model = new QuestionManagementModel();
		QuestionManagementInputParam inParam = new QuestionManagementInputParam();
		try {
			inParam.setStartIndex(0);
			inParam.setPageSize(ChemisboxConstant.TOTAL_QUESTION_RECORDS_IN_A_PAGE);
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
			QuestionManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			} else {
				this.model.setCurrentPage(1);
				this.model.setQuestionList(outParam.getQuestionList());
				this.model.setTotalPage(outParam.getTotalPages());
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("questionMap", this.model);
		map.put("questionObj", new Question());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.QUESTION_MENU);
		return "adminIndex";
	}

	@RequestMapping(value = "/admin/question/{index}", method = RequestMethod.GET)
	public String getquestions(@PathVariable("index") String index, ModelMap map) {
		this.model = new QuestionManagementModel();
		QuestionManagementInputParam inParam = new QuestionManagementInputParam();
		try {
			Integer startIndex = ChemisboxUtilities.getIntegerInString(index);
			if (startIndex == null) {
				startIndex = 0;
			}

			if (startIndex < 0) {
				this.model
						.setErrorMessage("Start index or page size must greater than 0");
			} else {
				inParam.setStartIndex((startIndex - 1)
						* ChemisboxConstant.TOTAL_QUESTION_RECORDS_IN_A_PAGE);
				this.model.setCurrentPage(startIndex);

				inParam.setPageSize(ChemisboxConstant.TOTAL_QUESTION_RECORDS_IN_A_PAGE);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
				QuestionManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				} else {
					this.model.setQuestionList(outParam.getQuestionList());
					this.model.setTotalPage(outParam.getTotalPages());
				}
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("questionMap", this.model);
		map.put("questionObj", new Question());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.QUESTION_MENU);
		return "adminIndex";
	}

	@RequestMapping(value = "/admin/question/loadDetails", method = RequestMethod.POST)
	public @ResponseBody QuestionManagementModel loadDataForUpdate(
			@RequestBody QuestionManagementModel model) {

		this.model = new QuestionManagementModel();
		QuestionManagementInputParam inParam = new QuestionManagementInputParam();

		if (model == null || model.getQuestionId() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setQuestionId(model.getQuestionId());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS);
			QuestionManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
			this.model.setQuestion(outParam.getQuestion());
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}


	@RequestMapping(value = "/admin/question/approved", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody QuestionManagementModel updatequestion(
			@RequestBody QuestionManagementModel model) {

		this.model = new QuestionManagementModel();
		QuestionManagementInputParam inParam = new QuestionManagementInputParam();

		if (model == null || model.getQuestionId() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setQuestionId(model.getQuestionId());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_UPDATE);
			QuestionManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}
	
	@RequestMapping(value = "/admin/question/delete/{id}", method = RequestMethod.GET)
	public String deleteElement(@PathVariable("id") String id, ModelMap map) {
		if(!map.containsAttribute("adminObject")){
			return "login";
		}
		this.model = new QuestionManagementModel();
		QuestionManagementInputParam inParam = new QuestionManagementInputParam();
		try {

			if(ChemisboxUtilities.isNullOrEmpty(id)){
				this.model.setErrorMessage("Invalid notation");
			} else {
				Integer questionId = ChemisboxUtilities.getIntegerInString(id);
				inParam.setQuestionId(questionId);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_DELETE);
				QuestionManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				}
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		map.put("elementMap", this.model);
		return "redirect:/admin/question/";
	}
	
	@Override
	public QuestionManagementModel execute(QuestionManagementModel model,
			ModelMap map) throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
