package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chemisbox.business.AddEquationBusiness;
import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AddEquationInputParam;
import com.chemisbox.model.AddEquationModel;
import com.chemisbox.output.AddEquationOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Controller
public class AddEquationController extends ChemisboxController<AddEquationBusiness, AddEquationModel> {

	private AddEquationBusiness addEquationBusiness;
	
	@RequestMapping(ChemisboxConstant.ADD_EQUATION_API)
	public @ResponseBody AddEquationModel addEquationAPI(@RequestBody AddEquationModel model) throws ChemisboxException{
//	public AddEquationModel addEquationAPI() throws ChemisboxException{
		this.model = model;
//		Equation equation = new Equation();
//		equation.setCondition("No Condition");
//		equation.setDescription("No Desc");
//		equation.setVideoLink("No Link");
//		equation.setEquation("NaOH + CuCl2 = Cu(OH)2 + 2NaCl");
//		
//		OxiReduceEquation oxiReduce = new OxiReduceEquation();
//		oxiReduce.setMolOxi(1);
//		oxiReduce.setMolReduce(1);
//		oxiReduce.setOxiEquation("H− − 1e− = H");
//		oxiReduce.setReduceEquation("Na+ + 1e− = Na");
//		oxiReduce.setSummary("Na+ + H− = Na + H");
		
//		model.setEquation(equation);
//		model.setOxiReduce(oxiReduce);
		try {
			this.model = this.execute();
		} catch (ChemisboxException e) {
			throw e;
		}
		return this.model;
	}
	
	@Override
	public AddEquationModel execute() throws ChemisboxException {
		//this.business = new AddEquationBusiness();
		AddEquationInputParam inParam = new AddEquationInputParam();
		
		//Equation is null
		if(model.getEquation() == null){
			model.setErrorMessage("Equation object is not null");
			return model;
		}
		
		if(ChemisboxUtilities.isNullOrEmpty(model.getEquation().getEquation())){
			model.setErrorMessage("Equation string is not null");
			return model;
		}
		
		this.business = this.addEquationBusiness;
		
		inParam.setEquation(model.getEquation());
		inParam.setIon(model.getIon());
		inParam.setOxiReduce(model.getOxiReduce());
		
		AddEquationOutputParam outParam = this.business.execute(inParam);
		//Has error
		if(!ChemisboxUtilities.isNullOrEmpty(outParam.getErrorMessage())){
			model.setErrorMessage(outParam.getErrorMessage());
		}
		return this.model;
	}
	
}
