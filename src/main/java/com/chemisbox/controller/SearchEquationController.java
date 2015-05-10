package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chemisbox.business.SearchEquationBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.SearchEquationInputParam;
import com.chemisbox.model.SearchEquationModel;
import com.chemisbox.output.SearchEquationOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class SearchEquationController extends
		ChemisboxController<SearchEquationBusiness, SearchEquationModel> {

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchEquationBySubmit(@ModelAttribute("searchModel") SearchEquationModel model,
            ModelMap map) throws ChemisboxException {
		model.setCurrentPage(0);
		this.model = execute(model, map);
		map.put("searchModel", this.model);
		return "search";
	}

	@RequestMapping(value = "/detail/{keyword}", method = RequestMethod.GET)
	public String getDetails(@PathVariable("keyword") String keyWord,
            ModelMap map) throws ChemisboxException {
		SearchEquationModel searchEquationModel = new  SearchEquationModel();
		searchEquationModel.setKeyWord(keyWord.trim());
		this.model = execute(searchEquationModel, map);
		map.put("searchModel", this.model);
		return "search";
	}
	
	@RequestMapping(value = "/search/", method = RequestMethod.POST)
//	@PathVariable("keyword") String keyWord
	public @ResponseBody SearchEquationModel searchEquationByAjax(
			@RequestBody SearchEquationModel model) throws ChemisboxException {
//		SearchEquationModel searchEquationModel = new SearchEquationModel();
//		searchEquationModel.setKeyWord(model.getKeyWord().trim());
		this.model = execute(model, null);
		return this.model;
	}
	
	@Override
	public  SearchEquationModel execute(SearchEquationModel model, ModelMap map) throws ChemisboxException {
		
		if (ChemisboxUtilities.isNullOrEmpty(model.getKeyWord())) {
			model.setErrorMessage("Key word is null");
			return model;
		}
		SearchEquationInputParam inParam = new SearchEquationInputParam();
		inParam.setKeyWord(ChemisboxUtilities.trimFullSize(model.getKeyWord()));
		inParam.setCurrentPage(model.getCurrentPage() * ChemisboxConstant.EQUATION_RECORD_NUMBER_IN_RESULT);
		SearchEquationOutputParam outParam = this.business.execute(inParam);
		if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
			model.setErrorMessage(outParam.getErrorMessage());
		}
		model.setEquationList(outParam.getEquationList());
		model.setChemical(outParam.getChemical());
		model.setElement(outParam.getElement());
		return model;
	}
}