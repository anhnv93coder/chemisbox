package com.chemisbox.business;

import java.util.ArrayList;
import java.util.Date;
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
import com.chemisbox.input.EquationManagementInputParam;
import com.chemisbox.output.EquationManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class EquationManagementBusiness
		extends
		ChemisboxBusiness<EquationManagementInputParam, EquationManagementOutputParam> {

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

	@Override
	public EquationManagementOutputParam execute(
			EquationManagementInputParam inParam) throws ChemisboxException {
		this.out = new EquationManagementOutputParam();
		Long ionId = null;
		Long equationId = null;
		Long oxiId = null;
		Equation equationObj = null;
		IonEquation ionObj = null;
		OxiReduceEquation oxiObj = null;
		List<ChemistryEquation> chemicalList = null;
		try {
			switch (inParam.getBusinessType()) {
			case ChemisboxConstant.BUSINESS_FOR_ADD:
				equationObj = inParam.getEquation();
				ionObj = equationObj.getIonEquation();
				oxiObj = equationObj.getOxiReduceEquation();

				String equation = ChemisboxUtilities.trimFullSize(equationObj
						.getEquation());

				chemicalList = mergeAllList(equation);

				if (ionObj != null) {
					ionId = ionDao.add(ionObj);
					ionObj.setIonId(ionId);
					ionObj.getEquations().add(equationObj);
					equationObj.setIonEquation(ionObj);
				}

				if (oxiObj != null) {
					oxiId = oxiDao.add(oxiObj);
					oxiObj.setOxiReduceId(oxiId);
					oxiObj.getEquations().add(equationObj);
					equationObj.setOxiReduceEquation(oxiObj);
				}

				equationId = equationDao.add(equationObj);

				addListChemistryEquation(equationId, chemicalList);

				break;

			case ChemisboxConstant.BUSINESS_FOR_DELETE:
				
				equationObj = equationDao.get(inParam.getEquationId());
				ionObj = equationObj.getIonEquation();
				oxiObj = equationObj.getOxiReduceEquation();
				
				
				
				break;

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				List<Equation> equationList = equationDao.list(
						inParam.getStartIndex(), inParam.getPageSize());

				if (ChemisboxUtilities.isNullOrEmpty(equationList)) {
					this.out.setErrorMessage("Not found any equation");
					return this.out;
				}
				Long equationCounter = equationDao.getCount();

				long totalPage = 0;
				if (equationCounter
						% ChemisboxConstant.TOTAL_EQUATION_RECORDS_IN_A_PAGE == 0) {
					totalPage = equationCounter
							/ ChemisboxConstant.TOTAL_EQUATION_RECORDS_IN_A_PAGE;
				} else {
					totalPage = equationCounter
							/ ChemisboxConstant.TOTAL_EQUATION_RECORDS_IN_A_PAGE
							+ 1;
				}

				this.out.setTotalPages(totalPage);
				this.out.setEquationList(equationList);
				break;

			case ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS:
				equationObj = equationDao.get(inParam.getEquationId());
				if (equationObj == null) {
					this.out.setErrorMessage("Not found any equation with id = "
							+ inParam.getEquationId());
					return this.out;
				}
				this.out.setEquation(equationObj);
				break;

			case ChemisboxConstant.BUSINESS_FOR_UPDATE:
				
				boolean mustIonDelete = false;
				boolean mustOxiDelete = false;
				equationObj = inParam.getEquation();
				ionObj = equationObj.getIonEquation();
				oxiObj = equationObj.getOxiReduceEquation();
				IonEquation tempIonObj = null;
				OxiReduceEquation tempOxiObj = null;
				Equation tempEquationObj = equationDao.get(equationObj.getEquationId());
				
				if (ionObj != null){
					tempIonObj = ionDao.get(ionObj.getIonId());
					if(!ChemisboxUtilities.isNullOrEmpty(ionObj.getIonEquation())
							&& !ChemisboxUtilities.isNullOrEmpty(ionObj.getShortcutIonEquation())){
						if(ionObj.getIonId() == null){
							ionId = ionDao.add(ionObj);
							tempEquationObj.setIonEquation(ionObj);
						} else {
							if (!ionObj.getIonEquation().equalsIgnoreCase(tempIonObj.getIonEquation()) 
									|| !ionObj.getShortcutIonEquation().equalsIgnoreCase(tempIonObj.getShortcutIonEquation())) {
								tempIonObj.setIonEquation(ionObj.getIonEquation());
								tempIonObj.setShortcutIonEquation(ionObj.getShortcutIonEquation());
								ionId = ionDao.update(tempIonObj);
							}
						}	
					} else {
						if(tempEquationObj.getIonEquation() != null){
							tempEquationObj.getIonEquation().setIonId(null);
							mustIonDelete = true;
						}
					}
				}
				
				if (oxiObj != null){
					tempOxiObj = oxiDao.get(oxiObj.getOxiReduceId());
					if(!ChemisboxUtilities.isNullOrEmpty(oxiObj.getOxiEquation())
						&& !ChemisboxUtilities.isNullOrEmpty(oxiObj.getReduceEquation())
						&& !ChemisboxUtilities.isNullOrEmpty(oxiObj.getSummary())){
						if(oxiObj.getOxiReduceId() == null){
							oxiId = oxiDao.add(oxiObj);
							tempEquationObj.setOxiReduceEquation(oxiObj);
						} else {
							if (!oxiObj.getOxiEquation().equalsIgnoreCase(tempOxiObj.getOxiEquation()) 
									|| !oxiObj.getReduceEquation().equalsIgnoreCase(tempOxiObj.getReduceEquation())
									|| !oxiObj.getSummary().equalsIgnoreCase(tempOxiObj.getSummary())) {
								tempOxiObj.setOxiEquation(oxiObj.getOxiEquation());
								tempOxiObj.setReduceEquation(oxiObj.getReduceEquation());
								tempOxiObj.setSummary(oxiObj.getSummary());
								oxiId = oxiDao.update(tempOxiObj);
							}
						}
					} else {
						if(tempEquationObj.getOxiReduceEquation() != null){
							tempEquationObj.getOxiReduceEquation().setOxiReduceId(null);
							mustOxiDelete = true;
						}
					}
				}
				
				String equationStr = equationObj.getEquation();

				if (!tempEquationObj.getEquation()
						.equalsIgnoreCase(equationStr)) {
					tempEquationObj.setCondition(equationObj.getCondition());
					tempEquationObj.setEquation(equationObj.getEquation());
					chemistryEquationDao.delete(equationObj.getEquationId());
					chemicalList = mergeAllList(equationStr);
					equationId = equationObj.getEquationId();
					addListChemistryEquation(equationId, chemicalList);
				}
				
				tempEquationObj.setDescription(equationObj.getDescription()); 
				tempEquationObj.setCondition(equationObj.getCondition());
				tempEquationObj.setVideoLink(equationObj.getVideoLink());
				tempEquationObj.setEditedDate(new Date());
				
				equationDao.update(tempEquationObj);
				
				if(mustIonDelete){
					ionDao.delete(tempIonObj);
				}
				if(mustOxiDelete){
					oxiDao.delete(tempOxiObj);
				}

				break;

			default:
				throw new ChemisboxException("Business type invalid");
			}
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	private void addListChemistryEquation(Long equationId,
			List<ChemistryEquation> chemicalList) throws ChemisboxException {
		try {
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
			throw new ChemisboxException(e);
		}
	}

	private List<ChemistryEquation> mergeAllList(String source) {
		String[] chemicalArray = source.split("=");
		String[] inputArray = chemicalArray[0].split("\\+");
		String[] outputArr = chemicalArray[1].split("\\+");

		// Parse equation string to chemical list
		List<ChemistryEquation> chemicalList = new ArrayList<ChemistryEquation>();
		List<ChemistryEquation> inputList = mergeChemistryEquationList(
				inputArray, ChemisboxConstant.INPUT);
		List<ChemistryEquation> outputList = mergeChemistryEquationList(
				outputArr, ChemisboxConstant.OUTPUT);
		chemicalList.addAll(inputList);
		chemicalList.addAll(outputList);
		return chemicalList;
	}

	private List<ChemistryEquation> mergeChemistryEquationList(
			String[] dataArray, int typeOf) {
		List<ChemistryEquation> list = new ArrayList<ChemistryEquation>();

		//
		Pattern patternForNumber = Pattern.compile("\\d+");
		Pattern patternForString = Pattern.compile("[a-zA-Z()]+[0-9]*");
		Pattern patternCondition = Pattern
				.compile("[↑↓]?\\({1}[a-zA-Z0-9]+\\){1}");
		//
		ChemistryEquation chemistryEquationElement = null;
		Matcher matcher = null;

		for (int i = 0; i < dataArray.length; i++) {
			chemistryEquationElement = new ChemistryEquation();
			String source = dataArray[i].trim();
			matcher = patternForNumber.matcher(source);
			if (matcher.find()) {
				chemistryEquationElement.setNumberOfAtomic(Integer
						.parseInt(matcher.group()));
			}
			matcher = patternForString.matcher(source);
			if (matcher.find()) {
				chemistryEquationElement.setChemicalFormula(matcher.group());
			}
			matcher = patternCondition.matcher(source);
			if (matcher.find()) {
				chemistryEquationElement.setCondition(matcher.group());
			}
			chemistryEquationElement.setChemicalTypeof(typeOf);
			list.add(chemistryEquationElement);
		}
		return list;
	}

	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

	public void setEquationDao(EquationDAO equationDao) {
		this.equationDao = equationDao;
	}

	public void setIonDao(IonEquationDAO ionDao) {
		this.ionDao = ionDao;
	}

	public void setOxiDao(OxiReduceEquationDAO oxiDao) {
		this.oxiDao = oxiDao;
	}

	public void setChemistryEquationDao(
			ChemistryEquationDAO chemistryEquationDao) {
		this.chemistryEquationDao = chemistryEquationDao;
	}

}
