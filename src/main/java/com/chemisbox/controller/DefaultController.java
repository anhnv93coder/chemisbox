package com.chemisbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.dao.EquationDAO;

@Controller
public class DefaultController {
	
	@Autowired
	private EquationDAO equationDao;
	
	@Autowired
	private ChemicalDAO chemicalDao;
	
	@RequestMapping("/")
	public String getIndex(){
		
		return "index";
	}
}
