package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chemisbox.model.SearchEquationModel;

@Controller
public class DefaultController{
		
	@RequestMapping("/")
	public String getIndex(ModelMap map){
		SearchEquationModel searchModel = new SearchEquationModel();
		map.put("searchModel", searchModel);
		return "index";
	}
	
}
