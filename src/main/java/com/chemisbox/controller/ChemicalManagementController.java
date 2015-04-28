package com.chemisbox.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chemisbox.business.ChemicalManagementBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.entity.Chemical;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.ChemicalManagementInputParam;
import com.chemisbox.model.ChemicalManagementModel;
import com.chemisbox.output.ChemicalManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class ChemicalManagementController
		extends
		ChemisboxController<ChemicalManagementBusiness, ChemicalManagementModel> {

	@RequestMapping(value = {"/admin/chemical", "/admin/chemical/"}, method = RequestMethod.GET)
	public String defaultAPI(ModelMap map) {
		this.model = new ChemicalManagementModel();
		ChemicalManagementInputParam inParam = new ChemicalManagementInputParam();
		try {
			inParam.setStartIndex(0);
			inParam.setPageSize(ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE);
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
			ChemicalManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			} else {
				this.model.setCurrentPage(1);
				this.model.setChemicalList(outParam.getChemicalList());
				this.model.setTotalPage(outParam.getTotalPages());
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("chemicalMap", this.model);
		map.put("chemicalObj", new Chemical());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.CHEMICAL_MENU);
		return "adminIndex";
	}

	@RequestMapping(value = "/admin/chemical/{index}", method = RequestMethod.GET)
	public String getChemicals(@PathVariable("index") String index, ModelMap map) {
		this.model = new ChemicalManagementModel();
		ChemicalManagementInputParam inParam = new ChemicalManagementInputParam();
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
						* ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE);
				this.model.setCurrentPage(startIndex);

				inParam.setPageSize(ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
				ChemicalManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				} else {
					this.model.setChemicalList(outParam.getChemicalList());
					this.model.setTotalPage(outParam.getTotalPages());
				}
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("chemicalMap", this.model);
		map.put("chemicalObj", new Chemical());
		return "adminIndex";
	}

	@RequestMapping(value = "/admin/chemical/loadDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ChemicalManagementModel loadDataForUpdate(
			@RequestBody ChemicalManagementModel model) {

		this.model = new ChemicalManagementModel();
		ChemicalManagementInputParam inParam = new ChemicalManagementInputParam();

		if (model == null || model.getChemicalId() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setChemicalId(model.getChemicalId());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS);
			ChemicalManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
			this.model.setChemical(outParam.getChemical());
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/admin/chemical/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ChemicalManagementModel addChemical(
			@RequestBody ChemicalManagementModel model) {

		this.model = new ChemicalManagementModel();
		ChemicalManagementInputParam inParam = new ChemicalManagementInputParam();

		if (model == null || model.getChemical() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setChemical(model.getChemical());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_ADD);
			ChemicalManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/admin/chemical/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ChemicalManagementModel updateChemical(
			@RequestBody ChemicalManagementModel model) {

		this.model = new ChemicalManagementModel();
		ChemicalManagementInputParam inParam = new ChemicalManagementInputParam();

		if (model == null || model.getChemical() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setChemical(model.getChemical());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_UPDATE);
			ChemicalManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/admin/chemical/delete/{id}", method = RequestMethod.GET)
	public String deleteChemical(@PathVariable("id") String id, ModelMap map) {
		this.model = new ChemicalManagementModel();
		ChemicalManagementInputParam inParam = new ChemicalManagementInputParam();
		try {

			Long chemicalId = ChemisboxUtilities.getLongInString(id);
			if (chemicalId == null) {
				this.model.setErrorMessage("Chemical id invalid");
			} else {
				inParam.setChemicalId(chemicalId);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_DELETE);
				ChemicalManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				}
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		map.put("chemicalMap", this.model);
		return "redirect:/admin/chemical/";
	}

	@Override
	public ChemicalManagementModel execute(ChemicalManagementModel model)
			throws ChemisboxException {
		this.model = new ChemicalManagementModel();

		return this.model;
	}

}
