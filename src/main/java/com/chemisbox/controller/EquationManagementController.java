package com.chemisbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chemisbox.business.EquationManagementBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.entity.Chemical;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.EquationManagementInputParam;
import com.chemisbox.model.EquationManagementModel;
import com.chemisbox.output.EquationManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@RequestMapping("/admin/equation")
public class EquationManagementController extends ChemisboxController<EquationManagementBusiness, EquationManagementModel> {

	@Autowired
	private EquationManagementBusiness equationManagementBusiness;
	
	@RequestMapping("/")
	public String defaultAPI(ModelMap map){
		this.model = new EquationManagementModel();
		EquationManagementInputParam inParam = new EquationManagementInputParam();
		try {
			inParam.setStartIndex(0);
			inParam.setPageSize(ChemisboxConstant.TOTAL_EQUATION_RECORDS_IN_A_PAGE);
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
			this.business = equationManagementBusiness;
			EquationManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			} else {
				this.model.setCurrentPage(1);
				this.model.setEquationList(outParam.getEquationList());
				this.model.setTotalPage(outParam.getTotalPages());
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("equationMap", this.model);
		map.put("equationObj", new Chemical());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.EQUATION_MENU);
		return "adminIndex";
	}
	
	@RequestMapping("/{index}")
	public String getEquation(@PathVariable("index") String index, ModelMap map){
		this.model = new EquationManagementModel();
		EquationManagementInputParam inParam = new EquationManagementInputParam();
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
						* ChemisboxConstant.TOTAL_EQUATION_RECORDS_IN_A_PAGE);
				this.model.setCurrentPage(startIndex);

				inParam.setPageSize(ChemisboxConstant.TOTAL_EQUATION_RECORDS_IN_A_PAGE);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
				this.business = equationManagementBusiness;
				EquationManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				} else {
					this.model.setEquationList(outParam.getEquationList());
					this.model.setTotalPage(outParam.getTotalPages());
				}
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("equationMap", this.model);
		map.put("equationObj", new Chemical());
		return "adminIndex";
	}
	
	@RequestMapping(value = "/loadDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EquationManagementModel loadDataForUpdate(
			@RequestBody EquationManagementModel model) {

		this.model = new EquationManagementModel();
		EquationManagementInputParam inParam = new EquationManagementInputParam();

		if (model == null || model.getEquationId() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setEquationId(model.getEquationId());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS);
			this.business = equationManagementBusiness;
			EquationManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
			this.model.setEquation(outParam.getEquation());
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EquationManagementModel addEquation(
			@RequestBody EquationManagementModel model) {

		this.model = new EquationManagementModel();
		EquationManagementInputParam inParam = new EquationManagementInputParam();

		if (model == null || model.getEquation() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setEquation(model.getEquation());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_ADD);
			this.business = equationManagementBusiness;
			EquationManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EquationManagementModel updateEquation(
			@RequestBody EquationManagementModel model) {

		this.model = new EquationManagementModel();
		EquationManagementInputParam inParam = new EquationManagementInputParam();

		if (model == null || model.getEquation() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setEquation(model.getEquation());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_UPDATE);
			this.business = equationManagementBusiness;
			EquationManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEquation(@PathVariable("id") String id, ModelMap map) {
		this.model = new EquationManagementModel();
		EquationManagementInputParam inParam = new EquationManagementInputParam();
		try {

			Long equationId = ChemisboxUtilities.getLongInString(id);
			if (equationId == null) {
				this.model.setErrorMessage("Equation id invalid");
			} else {
				inParam.setEquationId(equationId);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_DELETE);
				this.business = equationManagementBusiness;
				EquationManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				}
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		map.put("equationMap", this.model);
		return "redirect:/admin/equation/";
	}
	
	@Override
	public EquationManagementModel execute(EquationManagementModel model)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
