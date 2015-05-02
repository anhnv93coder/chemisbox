package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chemisbox.business.ShowDashboardBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.model.ShowDashboardModel;
import com.chemisbox.output.ShowDashboardOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("adminObject")
public class ShowDashboardController extends ChemisboxController<ShowDashboardBusiness, ShowDashboardModel> {

	@RequestMapping(value = {"/admin/dashboard", "/admin/dashboard/"})
	public String doDashboard(ModelMap map) throws ChemisboxException {
		if(!map.containsAttribute("adminObject")){
			return "login";
		}
		this.model = new ShowDashboardModel();
		ShowDashboardOutputParam outParam = this.business.execute(null);
		if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
			this.model.setErrorMessage(outParam.getErrorMessage());
		}
		this.model.setChemicalCounter(outParam.getChemicalCounter());
		this.model.setElementCounter(outParam.getElementCounter());
		this.model.setEquationCounter(outParam.getEquationCounter());
		this.model.setQuestionCounter(outParam.getQuestionCounter());
		this.model.setQuestionIsNotApprovedCounter(outParam.getQuestionIsNotApprovedCounter());
		this.model.setUserCounter(outParam.getUserCounter());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.DASHBOARD_MENU);
		map.put("dashboardModel", this.model);
		return "adminIndex";
	}
	
	@Override
	public ShowDashboardModel execute(ShowDashboardModel model, ModelMap map)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
