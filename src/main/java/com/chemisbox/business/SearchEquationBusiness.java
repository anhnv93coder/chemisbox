package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.EquationDAO;
import com.chemisbox.entity.Equation;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.SearchEquationInputParam;
import com.chemisbox.output.SearchEquationOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Transactional
public class SearchEquationBusiness extends
		ChemisboxBusiness<SearchEquationInputParam, SearchEquationOutputParam> {

	@Autowired
	private EquationDAO equationDao;

	@Override
	public SearchEquationOutputParam execute(SearchEquationInputParam inParam)
			throws ChemisboxException {
		this.out = new SearchEquationOutputParam();
		String keyWord = inParam.getKeyWord();
		List<Equation> equationList = null;
		// Ex: keyWord is "= Na"
		if (Character.toString(keyWord.charAt(0)).equalsIgnoreCase("=")) {
			keyWord = keyWord.substring(1, keyWord.length()).trim();
			equationList = equationDao.selectByChemical(keyWord, ChemisboxConstant.OUTPUT);
		}else{
			//Ex: keyWord is "Na"
			equationList = equationDao.selectByChemical(keyWord, ChemisboxConstant.INPUT);
		}
		
		if(ChemisboxUtilities.isNullOrEmpty(equationList)){
			this.out.setErrorMessage("Not found any equation with key word: " + keyWord);
			return this.out;
		}
		this.out.setEquationList(equationList);
		return this.out;
	}

	public void setEquationDao(EquationDAO equationDao) {
		this.equationDao = equationDao;
	}

}
