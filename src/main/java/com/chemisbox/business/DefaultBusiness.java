package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.dao.ElementDAO;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.DefaultInputParam;
import com.chemisbox.output.DefaultOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class DefaultBusiness extends
		ChemisboxBusiness<DefaultInputParam, DefaultOutputParam> {

	@Autowired
	private ChemicalDAO chemicalDao;

	@Autowired
	private ElementDAO elementDao;

	@Override
	public DefaultOutputParam execute(DefaultInputParam inParam)
			throws ChemisboxException {
		this.out = new DefaultOutputParam();
		try {
			List<String> formulaDataList = chemicalDao.selectFormulaAndNameList();
			if(ChemisboxUtilities.isNullOrEmpty(formulaDataList)){
				this.out.setErrorMessage("");
				return this.out;
			}
			this.out.setSuggestList(formulaDataList);
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}
	
	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

	public void setElementDao(ElementDAO elementDao) {
		this.elementDao = elementDao;
	}

}
