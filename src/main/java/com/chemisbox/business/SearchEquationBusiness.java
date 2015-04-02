package com.chemisbox.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.dao.ElementDAO;
import com.chemisbox.dao.EquationDAO;
import com.chemisbox.entity.Chemical;
import com.chemisbox.entity.Element;
import com.chemisbox.entity.Equation;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.SearchEquationInputParam;
import com.chemisbox.output.SearchEquationOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Transactional
public class SearchEquationBusiness extends
		ChemisboxBusiness<SearchEquationInputParam, SearchEquationOutputParam> {

	@Autowired
	private ElementDAO elementDao;

	@Autowired
	private ChemicalDAO chemicalDao;

	@Autowired
	private EquationDAO equationDao;

	@Override
	public SearchEquationOutputParam execute(SearchEquationInputParam inParam)
			throws ChemisboxException {
		this.out = new SearchEquationOutputParam();
		String keyWord = inParam.getKeyWord();
		List<Equation> equationList = null;
		try {
			if (keyWord.contains(">")) {
				List<String> keyWordList = ChemisboxUtilities
						.validArrayIsSplit(keyWord, ">");
				equationList = new ArrayList<Equation>();

				//if size keyWordList < 2 after split then invalid 
				if (keyWordList.size() < 2) {
					this.out.setErrorMessage("Key word is invalid");
					return this.out;
				}

				//if size keyWordList have 2 element only
				if (keyWordList.size() == 2) {
					List<Equation> equations = equationDao.selectByChemicals(
							keyWordList.get(0), keyWordList.get(1));
					equationList.addAll(equations);
					
				//if size keyWordList greater than 2 element
				} else {
					for (int i = 0; i < keyWordList.size() - 1; i++) {
						List<Equation> equations = equationDao
								.selectByChemicals(keyWordList.get(i),
										keyWordList.get(i + 1));
						equationList.addAll(equations);
					}
				}
			} else {
				// Find equation
				// Ex: keyWord is "= Na"
				if (Character.toString(keyWord.charAt(0)).equalsIgnoreCase("=")) {
					keyWord = keyWord.substring(1, keyWord.length()).trim();
					equationList = equationDao.selectByChemical(keyWord,
							ChemisboxConstant.OUTPUT);
				} else {
					// Ex: keyWord is "Na"
					equationList = equationDao.selectByChemical(keyWord,
							ChemisboxConstant.INPUT);
				}

				// Find element
				Element element = elementDao.get(keyWord);
				if (element != null) {
					this.out.setElement(element);
				} else {// Find chemical
					List<Chemical> chemicals = chemicalDao.list(keyWord);
					if (!ChemisboxUtilities.isNullOrEmpty(chemicals)) {
						this.out.setChemical(chemicals.get(0));
					}
				}
			}

			if (ChemisboxUtilities.isNullOrEmpty(equationList)) {
				this.out.setErrorMessage("Not found any equation with key word: "
						+ keyWord);
				return this.out;
			}
			this.out.setEquationList(equationList);
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setEquationDao(EquationDAO equationDao) {
		this.equationDao = equationDao;
	}

	public void setElementDao(ElementDAO elementDao) {
		this.elementDao = elementDao;
	}

	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

}
