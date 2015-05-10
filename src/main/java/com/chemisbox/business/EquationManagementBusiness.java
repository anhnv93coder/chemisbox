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
import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.ChemistryEquation;
import com.chemisbox.entity.Equation;
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
	private ChemistryEquationDAO chemistryEquationDao;

	@Override
	public EquationManagementOutputParam execute(
			EquationManagementInputParam inParam) throws ChemisboxException {
		this.out = new EquationManagementOutputParam();
		Long equationId = null;
		Equation equationObj = null;
		List<ChemistryEquation> chemicalList = null;
		List<Equation> equationList = null;
		long equationCounter = 0;
		long totalPage = 0;
		try {
			switch (inParam.getBusinessType()) {
			case ChemisboxConstant.BUSINESS_FOR_ADD:
				equationObj = inParam.getEquation();

				equationId = equationDao.add(equationObj);

				chemicalList = mergeAllList(equationObj.getEquation());

				addListChemistryEquation(equationId, chemicalList);

				break;

			case ChemisboxConstant.BUSINESS_FOR_DELETE:

				equationObj = equationDao.get(inParam.getEquationId());

				break;

			case ChemisboxConstant.BUSINESS_FOR_SEARCH:
				String keyWord = inParam.getKeyWord();
				StringBuffer buffer = new StringBuffer();
				buffer.append("%");
				buffer.append(keyWord);
				buffer.append("%");

				equationList = equationDao.searchByKeyWord(buffer.toString(),
						inParam.getStartIndex(), inParam.getPageSize());

				if (ChemisboxUtilities.isNullOrEmpty(equationList)) {
					this.out.setErrorMessage("Not found any equation");
					return this.out;
				}
				equationCounter = equationDao.getCountByKeyWord(buffer
						.toString());

				totalPage = 0;
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

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				equationList = equationDao.list(inParam.getStartIndex(),
						inParam.getPageSize());

				if (ChemisboxUtilities.isNullOrEmpty(equationList)) {
					this.out.setErrorMessage("Not found any equation");
					return this.out;
				}
				equationCounter = equationDao.getCount();

				totalPage = 0;
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

				equationObj = inParam.getEquation();
				Equation tempEquationObj = equationDao.get(equationObj
						.getEquationId());

				String equationStr = equationObj.getEquation();

				if (!tempEquationObj.getEquation()
						.equalsIgnoreCase(equationStr)) {
					tempEquationObj.setCondition(equationObj.getCondition());
					tempEquationObj.setEquation(equationObj.getEquation());
					chemistryEquationDao.delete(equationObj.getEquationId(),
							true);
					chemicalList = mergeAllList(equationStr);
					equationId = equationObj.getEquationId();
					addListChemistryEquation(equationId, chemicalList);
				}

				tempEquationObj.setDescription(equationObj.getDescription());
				tempEquationObj.setCondition(equationObj.getCondition());
				tempEquationObj.setVideoLink(equationObj.getVideoLink());
				tempEquationObj.setIonEquation(equationObj.getIonEquation());
				tempEquationObj.setShortcutIonEquation(equationObj
						.getShortcutIonEquation());
				tempEquationObj.setMolOxi(equationObj.getMolOxi());
				tempEquationObj.setMolReduce(equationObj.getMolReduce());
				tempEquationObj.setOxiEquation(equationObj.getOxiEquation());
				tempEquationObj.setReduceEquation(equationObj
						.getReduceEquation());
				tempEquationObj.setSummary(equationObj.getSummary());
				tempEquationObj.setEditedDate(new Date());

				equationDao.update(tempEquationObj);

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
		Pattern patternForNumber = Pattern.compile("^\\d+");
		Pattern patternForString = Pattern
				.compile("[a-zA-Z()]+[0-9]*(([\\(]?[a-zA-Z]*[\\)]?)*[0-9]*)*");
		Pattern patternCondition = Pattern.compile(
				"[↑↓]?\\({1}\\w+\\s?\\w+\\){1}[↑↓]?$",
				Pattern.UNICODE_CHARACTER_CLASS);
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
			} else {
				chemistryEquationElement.setCondition("");
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

	public void setChemistryEquationDao(
			ChemistryEquationDAO chemistryEquationDao) {
		this.chemistryEquationDao = chemistryEquationDao;
	}

}
