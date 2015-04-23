package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.ChemicalDAO;
import com.chemisbox.entity.Chemical;
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

	@Override
	public ChemicalManagementOutputParam execute(
			ChemicalManagementInputParam inParam) throws ChemisboxException {

		this.out = new ChemicalManagementOutputParam();
		Long chemicalId = null;
		Chemical chemicalObj = null;
		try {
			switch (inParam.getBusinessType()) {
			case ChemisboxConstant.BUSINESS_FOR_ADD:			
				Long oldId = chemicalDao.get(inParam.getChemical().getFormula());
				if(oldId != null){
					this.out.setErrorMessage("Chemical is exist");
					return this.out;
				}
				
				chemicalId = chemicalDao.add(inParam.getChemical());
				if(chemicalId == null){
					this.out.setErrorMessage("Adding failed");
					return this.out;
				}
				
				break;

			case ChemisboxConstant.BUSINESS_FOR_DELETE:
				chemicalId = inParam.getChemicalId();
				chemicalObj = chemicalDao.get(chemicalId);
				if(chemicalObj == null){
					this.out.setErrorMessage("Chemical id not exist");
					return this.out;
				}
				if(!chemicalDao.delete(chemicalObj)){
					this.out.setErrorMessage("Delete chemical failed");
					return this.out;
				}
				break;
				
			case ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS:
				chemicalObj  = chemicalDao.get(inParam.getChemicalId());
				if(chemicalObj == null){
					this.out.setErrorMessage("Chemical not exist");
					return this.out;
				}
				this.out.setChemical(chemicalObj);
				break;

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				List<Chemical> chemicalList = chemicalDao.list(inParam.getStartIndex(), inParam.getPageSize());
								
				if(ChemisboxUtilities.isNullOrEmpty(chemicalList)){
					this.out.setErrorMessage("Not found any chemical object");
					return this.out;
				}
				
				Long totalRecords = chemicalDao.getCount();
				
				long totalPage = 0;
				if(totalRecords % ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE == 0){
					totalPage = totalRecords / ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE;
				}else{
					totalPage = totalRecords / ChemisboxConstant.TOTAL_CHEMICAL_RECORDS_IN_A_PAGE + 1;
				}
				this.out.setTotalPages(totalPage);
				this.out.setChemicalList(chemicalList);
				break;

			case ChemisboxConstant.BUSINESS_FOR_UPDATE:
				chemicalObj = inParam.getChemical();
				chemicalId = chemicalDao.update(chemicalObj);
				if(chemicalId == null){
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

	

	public void setChemicalDao(ChemicalDAO chemicalDao) {
		this.chemicalDao = chemicalDao;
	}

}
