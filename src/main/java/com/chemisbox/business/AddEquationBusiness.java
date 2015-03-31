package com.chemisbox.business;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.dao.ChemistryEquationDAO;
import com.chemisbox.dao.EquationDAO;
import com.chemisbox.dao.IonEquationDAO;
import com.chemisbox.dao.OxiReduceEquationDAO;
import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.ChemistryEquation;
import com.chemisbox.entity.Equation;
import com.chemisbox.entity.IonEquation;
import com.chemisbox.entity.OxiReduceEquation;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AddEquationInputParam;
import com.chemisbox.output.AddEquationOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
public class AddEquationBusiness extends
		ChemisboxBusiness<AddEquationInputParam, AddEquationOutputParam> {
	@Autowired
	private ChemicalDAO chemicalDao;

	@Autowired
	private EquationDAO equationDao;

	@Autowired
	private IonEquationDAO ionDao;

	@Autowired
	private OxiReduceEquationDAO oxiDao;

	@Autowired
	private ChemistryEquationDAO chemistryEquationDao;

	public AddEquationBusiness() {

	}

	@Transactional
	@Override
	public AddEquationOutputParam execute(AddEquationInputParam inParam)
			throws ChemisboxException {

		Equation equationObj = inParam.getEquation();
		IonEquation ionObj = inParam.getIon();
		OxiReduceEquation oxiObj = inParam.getOxiReduce();

		this.out = new AddEquationOutputParam();
		Long ionId = null;
		Long equationId = null;
		Long oxiId = null;
		try {
			String equation = ChemisboxUtilities.trimFullSize(equationObj
					.getEquation());

			String[] chemicalArray = equation.split("=");
			String[] inputArray = chemicalArray[0].split("\\+");
			String[] outputArr = chemicalArray[1].split("\\+");

			if (ionObj != null) {
				ionId = ionDao.add(ionObj);
				ionObj.setIonId(ionId);
			}

			if (oxiObj != null) {
				oxiId = oxiDao.add(oxiObj);
				oxiObj.setOxiReduceId(oxiId);
			}

			// Parse equation string to chemical list
			List<ChemistryEquation> chemicalList = new ArrayList<ChemistryEquation>();
			List<ChemistryEquation> inputList = mergeChemistryEquationList(
					inputArray, ChemisboxConstant.INPUT);
			List<ChemistryEquation> outputList = mergeChemistryEquationList(
					outputArr, ChemisboxConstant.OUTPUT);
			chemicalList.addAll(inputList);
			chemicalList.addAll(outputList);

			equationObj.setIonEquation(ionObj);
			if (ionObj != null) {
				ionObj.getEquations().add(equationObj);
				equationObj.setIonEquation(ionObj);
			}

			if (oxiObj != null) {
				oxiObj.getEquations().add(equationObj);
				equationObj.setOxiReduceEquation(oxiObj);
			}

			equationId = equationDao.add(equationObj);

			Chemical chemical = null;

			for (int i = 0; i < chemicalList.size(); i++) {
				ChemistryEquation element = chemicalList.get(i);
				Long chemicalId = chemicalDao.get(element.getChemicalFormula());
				if (chemicalId == null) {
					chemical = new Chemical();
					chemical.setFormula(element.getChemicalFormula());
					chemicalId = chemicalDao.add(chemical);
				}
				element.setChemicalId(chemicalId);
				element.setEquationId(equationId);
				chemistryEquationDao.add(element);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.out;
	}

	private List<ChemistryEquation> mergeChemistryEquationList(
			String[] dataArray, int typeOf) {
		List<ChemistryEquation> list = new ArrayList<ChemistryEquation>();

		//
		Pattern patternForNumber = Pattern.compile("\\d+");
		Pattern patternForString = Pattern.compile("[a-zA-Z()]+[0-9]*");
		//
		ChemistryEquation chemistryEquationElement = null;
		Matcher matcher = null;

		for (int i = 0; i < dataArray.length; i++) {
			chemistryEquationElement = new ChemistryEquation();
			matcher = patternForNumber.matcher(dataArray[i].trim());
			if (matcher.find()) {
				chemistryEquationElement.setNumberOfAtomic(Integer
						.parseInt(matcher.group()));
			}
			matcher = patternForString.matcher(dataArray[i].trim());
			if (matcher.find()) {
				chemistryEquationElement.setChemicalFormula(matcher.group());
			}
			chemistryEquationElement.setChemicalTypeof(typeOf);
			list.add(chemistryEquationElement);
		}
		return list;
	}

	public ChemicalDAO getChemicalDao() {
		return chemicalDao;
	}

	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

	public EquationDAO getEquationDao() {
		return equationDao;
	}

	public void setEquationDao(EquationDAO equationDao) {
		this.equationDao = equationDao;
	}

	public IonEquationDAO getIonDao() {
		return ionDao;
	}

	public void setIonDao(IonEquationDAO ionDao) {
		this.ionDao = ionDao;
	}

	public OxiReduceEquationDAO getOxiDao() {
		return oxiDao;
	}

	public void setOxiDao(OxiReduceEquationDAO oxiDao) {
		this.oxiDao = oxiDao;
	}

	public ChemistryEquationDAO getChemistryEquationDao() {
		return chemistryEquationDao;
	}

	public void setChemistryEquationDao(
			ChemistryEquationDAO chemistryEquationDao) {
		this.chemistryEquationDao = chemistryEquationDao;
	}

}
