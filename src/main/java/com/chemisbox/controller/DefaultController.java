package com.chemisbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chemisbox.business.DefaultBusiness;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.model.DefaultModel;
import com.chemisbox.model.SearchEquationModel;
import com.chemisbox.output.DefaultOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class DefaultController extends ChemisboxController<DefaultBusiness, DefaultModel> {
	
	private List<String> suggestDataList;
		
	@RequestMapping("/")
	public String getIndex(ModelMap map) throws ChemisboxException{
		SearchEquationModel searchModel = new SearchEquationModel();
		if(ChemisboxUtilities.isNullOrEmpty(suggestDataList)){
			DefaultOutputParam outParam = this.business.execute(null);
			if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
				throw new ChemisboxException("Can not initial data");
			}
			suggestDataList = outParam.getSuggestList();
		}
		map.put("searchModel", searchModel);
		return "index";
	}
		
	@RequestMapping("/getData")
	public @ResponseBody DefaultModel getData(@RequestParam String keyWord){
		this.model = new DefaultModel();
		
		try {
			if(ChemisboxUtilities.isNullOrEmpty(keyWord)){
				this.model.setErrorMessage("Key word is null or empty");
				return this.model;
			}
			
			if(ChemisboxUtilities.isNullOrEmpty(suggestDataList)){
				this.model.setErrorMessage("Suggest data is null or empty");
				return this.model;
			}
			
			List<String> suggestList = simulateSearchResult(keyWord.trim(), suggestDataList);
			
			this.model.setSuggestList(suggestList);
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		return this.model;
	}

	@Override
	public DefaultModel execute(DefaultModel model) throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<String> simulateSearchResult(String keyWord, List<String> dataList){
		List<String> keyWordList = new  ArrayList<String>();
		for (String auto : dataList) {
			if(auto.toUpperCase().indexOf(keyWord.toUpperCase()) != -1){
				keyWordList.add(auto);
			}
		}
		
		return keyWordList;
	}

	
}
