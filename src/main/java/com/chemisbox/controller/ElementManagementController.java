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

import com.chemisbox.business.ElementManagementBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.entity.Element;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.ElementManagementInputParam;
import com.chemisbox.model.ElementManagementModel;
import com.chemisbox.output.ElementManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
@SessionAttributes("adminObject")
public class ElementManagementController extends ChemisboxController<ElementManagementBusiness, ElementManagementModel> {

	@RequestMapping(value = {"/admin/element", "/admin/element/"}, method = RequestMethod.GET)
	public String defaultAPI(ModelMap map) throws ChemisboxException{
		if(!map.containsAttribute("adminObject")){
			return "login";
		}
		this.model = new ElementManagementModel();
		ElementManagementInputParam inParam = new ElementManagementInputParam();
		try {
			inParam.setStartIndex(0);
			inParam.setPageSize(ChemisboxConstant.TOTAL_ELEMENT_RECORDS_IN_A_PAGE);
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
			ElementManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			} else {
				this.model.setCurrentPage(1);
				this.model.setElementList(outParam.getElementList());
				this.model.setTotalPage(outParam.getTotalPages());
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("elementMap", this.model);
		map.put("elementObj", new Element());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.ELEMENT_MENU);
		return "adminIndex";
	}

	@RequestMapping(value = "/admin/element/{index}", method = RequestMethod.GET)
	public String getelements(@PathVariable("index") String index, ModelMap map) {
		if(!map.containsAttribute("adminObject")){
			return "login";
		}
		this.model = new ElementManagementModel();
		ElementManagementInputParam inParam = new ElementManagementInputParam();
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
						* ChemisboxConstant.TOTAL_ELEMENT_RECORDS_IN_A_PAGE);
				this.model.setCurrentPage(startIndex);

				inParam.setPageSize(ChemisboxConstant.TOTAL_ELEMENT_RECORDS_IN_A_PAGE);
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LIST);
				ElementManagementOutputParam outParam = this.business
						.execute(inParam);
				if (!ChemisboxUtilities.isNullOrEmpty(outParam
						.getErrorMessage())) {
					this.model.setErrorMessage(outParam.getErrorMessage());
				} else {
					this.model.setElementList(outParam.getElementList());
					this.model.setTotalPage(outParam.getTotalPages());
				}
			}
		} catch (Exception e) {
			this.model.setErrorMessage(e.getMessage());
		}
		map.put("elementMap", this.model);
		map.put("elementObj", new Element());
		map.put(ChemisboxConstant.MENU_CONSTANT, ChemisboxConstant.ELEMENT_MENU);
		return "adminIndex";
	}

	@RequestMapping(value = "/admin/element/loadDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ElementManagementModel loadDataForUpdate(
			@RequestBody ElementManagementModel model, ModelMap map) throws ChemisboxException {
		if(!map.containsAttribute("adminObject")){
			throw new ChemisboxException("Nguoi dung chua dang nhap");
		}
		this.model = new ElementManagementModel();
		ElementManagementInputParam inParam = new ElementManagementInputParam();

		if (model == null || ChemisboxUtilities.isNullOrEmpty(model.getNotation())) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setNotation(model.getNotation().trim());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS);
			ElementManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
			this.model.setElement(outParam.getElement());
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/admin/element/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ElementManagementModel addelement(
			@RequestBody ElementManagementModel model, ModelMap map) throws ChemisboxException {
		if(!map.containsAttribute("adminObject")){
			throw new ChemisboxException("Nguoi dung chua dang nhap");
		}
		this.model = new ElementManagementModel();
		ElementManagementInputParam inParam = new ElementManagementInputParam();

		if (model == null || model.getElement() == null) {
			this.model.setErrorMessage("Null pointer");
			return this.model;
		}
		try {
			inParam.setNotation(model.getNotation().trim());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_ADD);
			ElementManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/admin/element/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ElementManagementModel updateelement(
			@RequestBody ElementManagementModel model, ModelMap map) throws ChemisboxException {
		try {
			if(!map.containsAttribute("adminObject")){
				throw new ChemisboxException("Nguoi dung chua dang nhap");
			}
			this.model = new ElementManagementModel();
			ElementManagementInputParam inParam = new ElementManagementInputParam();
	
			if (model == null || model.getElement() == null) {
				this.model.setErrorMessage("Null pointer");
				return this.model;
			}
		
			inParam.setElement(model.getElement());
			inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_UPDATE);
			ElementManagementOutputParam outParam = this.business
					.execute(inParam);
			if (!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())) {
				this.model.setErrorMessage(outParam.getErrorMessage());
			}
		} catch (Exception ex) {
			this.model.setErrorMessage(ex.getMessage());
		}
		return this.model;
	}

	@RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
	public String deleteElement(@PathVariable("id") String id, ModelMap map) {
		if(!map.containsAttribute("adminObject")){
			return "login";
		}
		this.model = new ElementManagementModel();
		ElementManagementInputParam inParam = new ElementManagementInputParam();
		try {

			if(ChemisboxUtilities.isNullOrEmpty(id)){
				this.model.setErrorMessage("Invalid notation");
			} else {
				inParam.setNotation(id.trim());
				inParam.setBusinessType(ChemisboxConstant.BUSINESS_FOR_DELETE);
				ElementManagementOutputParam outParam = this.business
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
		return "redirect:/admin/element/";
	}
	
	@Override
	public ElementManagementModel execute(ElementManagementModel model, ModelMap map)
			throws ChemisboxException {
		// TODO Auto-generated method stub
		return null;
	}

}
