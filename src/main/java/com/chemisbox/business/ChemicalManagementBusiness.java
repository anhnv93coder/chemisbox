package com.chemisbox.business;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.dao.ElementDAO;
import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.Element;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.ChemicalManagementInputParam;
import com.chemisbox.output.ChemicalManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class ChemicalManagementBusiness
		extends
		ChemisboxBusiness<ChemicalManagementInputParam, ChemicalManagementOutputParam> {

	@Autowired
	private ChemicalDAO chemicalDao;

	@Autowired
	private ElementDAO elementDao;

	@Override
	public ChemicalManagementOutputParam execute(
			ChemicalManagementInputParam inParam) throws ChemisboxException {

		this.out = new ChemicalManagementOutputParam();
		Long chemicalId = null;
		Chemical chemicalObj = null;
		double quantity = 0;
		try {
			switch (inParam.getBusinessType()) {
			case ChemisboxConstant.BUSINESS_FOR_ADD:
				chemicalObj = inParam.getChemical(); 
				Long oldId = chemicalDao
						.get(chemicalObj.getFormula());
				if (oldId != null) {
					this.out.setErrorMessage("Chemical is exist");
					return this.out;
				}

				quantity = chemicalQuantityCalculator(chemicalObj.getFormula());
				chemicalObj.setQuantity(quantity);
				
				chemicalId = chemicalDao.add(chemicalObj);
				if (chemicalId == null) {
					this.out.setErrorMessage("Adding failed");
					return this.out;
				}

				break;

			case ChemisboxConstant.BUSINESS_FOR_DELETE:
				chemicalId = inParam.getChemicalId();
				chemicalObj = chemicalDao.get(chemicalId);
				if (chemicalObj == null) {
					this.out.setErrorMessage("Chemical id not exist");
					return this.out;
				}
				if (!chemicalDao.delete(chemicalObj)) {
					this.out.setErrorMessage("Delete chemical failed");
					return this.out;
				}
				break;

			case ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS:
				chemicalObj = chemicalDao.get(inParam.getChemicalId());
				if (chemicalObj == null) {
					this.out.setErrorMessage("Chemical not exist");
					return this.out;
				}
				this.out.setChemical(chemicalObj);
				break;

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				List<Chemical> chemicalList = chemicalDao.list(
						inParam.getStartIndex(), inParam.getPageSize());

				if (ChemisboxUtilities.isNullOrEmpty(chemicalList)) {
					this.out.setErrorMessage("Not found any chemical object");
					return this.out;
				}

				Long totalRecords = chemicalDao.getCount();

				long totalPage = 0;
				if (totalRecords
						% ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE == 0) {
					totalPage = totalRecords
							/ ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE;
				} else {
					totalPage = totalRecords
							/ ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE
							+ 1;
				}
				this.out.setTotalPages(totalPage);
				this.out.setChemicalList(chemicalList);
				break;

			case ChemisboxConstant.BUSINESS_FOR_UPDATE:
				chemicalObj = inParam.getChemical();
				quantity = chemicalQuantityCalculator(chemicalObj.getFormula());
				chemicalObj.setQuantity(quantity);
				chemicalId = chemicalDao.update(chemicalObj);
				if (chemicalId == null) {
					this.out.setErrorMessage("Update chemical failed");
				}
				break;

			default:
				throw new ChemisboxException("Business invalid");
			}
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public double chemicalQuantityCalculator(String formula)
			throws ChemisboxException {
		double chemicalQuantity = 0;
		if (ChemisboxUtilities.isNullOrEmpty(formula)) {
			throw new ChemisboxException(
					"Lỗi hệ thống. Vui lòng liên hệ với quản trị.");
		}
					
		Pattern detectChemicalPattern = Pattern.compile("[A-Z]{1}[a-z]*(\\d)*");
		Pattern detectElementWithoutNumberPattern = Pattern.compile("[A-Z]{1}[a-z]*");
		Pattern detectBracketPattern = null;
		Pattern detectElementWithNumberPattern = Pattern.compile("[A-Z]{1}[a-z]*(\\d)*");;
		Pattern detectNumberPattern = Pattern.compile("\\d+$");
		
		Matcher detectChemicalMatcher = null;
		Matcher detectElementMatcher = null;
		Matcher detectElementWithoutNumberMatcher = null;
		Matcher detectNumberMatcher = null;
		
		Element element = null;
		double quantityValue = 0;
		if (formula.contains("(") && formula.contains(")")) {
			
			// Try detect Fe2 first
			detectElementMatcher = detectElementWithNumberPattern.matcher(formula);
			// Found Fe2
			if (detectElementMatcher.find()) {
				//Get Fe2
				String elementFistRaw = detectElementMatcher.group();
				
				// Get Fe
				detectElementWithoutNumberMatcher = detectElementWithoutNumberPattern.matcher(elementFistRaw);
				String elementFirst = detectElementWithoutNumberMatcher.find()? detectElementWithoutNumberMatcher.group() : null;
				
				// Get Fe information from db
				element = elementDao.get(elementFirst);
				if(element == null){
					throw new ChemisboxException("Lỗi hệ thống. Vui lòng liên hệ quản trị");
				}
				
				//Get 2
				detectNumberMatcher = detectNumberPattern.matcher(elementFistRaw);
				int atomicElementFirst = detectNumberMatcher.find()? Integer.parseInt(detectNumberMatcher.group()) : 1;  
				System.out.println("AtomicNumber: " + atomicElementFirst);
				
				chemicalQuantity += atomicElementFirst * element.getAtomicVolume();
						
			}

			detectBracketPattern = Pattern
					.compile("[\\(]{1}([A-Z]{1}[a-z]*(\\d)*)*[\\)]{1}(\\d)+");

			Matcher detectBracketMatcher = detectBracketPattern.matcher(formula);
			// Found format with (SO4)3
			if (detectBracketMatcher.find()) {
				
				// Get (SO4)3
				String rawValue = detectBracketMatcher.group();
				
				// Get 3
				detectNumberMatcher = detectNumberPattern.matcher(rawValue);
				int atomicAround = detectNumberMatcher.find() ? Integer
						.parseInt(detectNumberMatcher.group()) : 1;

				// Get S O4
				detectChemicalPattern = Pattern.compile("[A-Z]{1}[a-z]*(\\d)*");
				detectChemicalMatcher = detectChemicalPattern.matcher(rawValue);
				
				quantityValue = getQuantityOfChemicals(detectChemicalMatcher, atomicAround);
				chemicalQuantity += quantityValue;

			} else {
				// exception
			}
		} else {
			detectChemicalMatcher = detectChemicalPattern.matcher(formula);
			quantityValue = getQuantityOfChemicals(detectChemicalMatcher, 1);
			chemicalQuantity += quantityValue;
		}
		
		
//		
//		Pattern pattern = Pattern.compile("[A-Z]+[a-z]*[\\d]*");
//		Matcher matcher = pattern.matcher(formula);
//		Pattern pattern1 = Pattern.compile("[A-Z]+[a-z]*");
//		Matcher getElementMatcher = null;
//		Pattern pattern2 = Pattern.compile("\\d+$");
//		Matcher getNumberMatcher = null;
//		Element element1 = null;
//		while (matcher.find()) {
//			int atomicNumber = 1;	
//			getElementMatcher = pattern1.matcher(matcher.group());
//			if (getElementMatcher.find()) {
//				element1 = elementDao.get(getElementMatcher.group());
//				if(element1 == null){
//					throw new ChemisboxException("Lỗi hệ thống. Vui lòng liên hệ quản trị");
//				}
//			}
//
//			getNumberMatcher = pattern2.matcher(matcher.group());
//			if (getNumberMatcher.find()) {
//				atomicNumber = Integer.parseInt(getNumberMatcher.group());
//			}
//			chemicalQuantity += atomicNumber * element1.getAtomicVolume();
//		}
		return chemicalQuantity;
	}
	
	private double getQuantityOfChemicals(Matcher detectChemicalMatcher, int atomicAround) throws ChemisboxException {
		double summaryQuantity = 0;
		Matcher detectElementMatcher = null;
		Matcher detectNumberMatcher = null;
		Pattern detectElementWithoutNumberPattern = Pattern.compile("[A-Z]{1}[a-z]*");
		Pattern detectNumberPattern = Pattern.compile("\\d+$");
		Element element = null;
		while (detectChemicalMatcher.find()) {
			double atomicValue = 1;
			
			// Get S O4
			String elementValue = detectChemicalMatcher.group();
			detectElementMatcher = detectElementWithoutNumberPattern
					.matcher(elementValue);
			
			// Get S O
			if (detectElementMatcher.find()) {
				element = elementDao.get(detectElementMatcher.group());
				if(element == null){
					throw new ChemisboxException("Lỗi hệ thống. Vui lòng liên hệ quản trị");
				}
			}

			// Get 1 4
			detectNumberMatcher = detectNumberPattern
					.matcher(elementValue);
			
			if (detectNumberMatcher.find()) {
				atomicValue = Double.parseDouble(detectNumberMatcher.group());
			}
			
			summaryQuantity += atomicValue * atomicAround * element.getAtomicVolume();
		}
		return summaryQuantity;
	}

	public void setElementDao(ElementDAO elementDao) {
		this.elementDao = elementDao;
	}

	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

}
