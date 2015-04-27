package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.ElementDAO;
import com.chemisbox.entity.Element;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.ElementManagementInputParam;
import com.chemisbox.output.ElementManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class ElementManagementBusiness
		extends
		ChemisboxBusiness<ElementManagementInputParam, ElementManagementOutputParam> {

	@Autowired
	private ElementDAO elementDao;

	@Override
	public ElementManagementOutputParam execute(
			ElementManagementInputParam inParam) throws ChemisboxException {
		this.out = new ElementManagementOutputParam();
		
		String notation = null;
		Element elementObj = null;
		try {
			switch (inParam.getBusinessType()) {
			
			case ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS:
				elementObj = elementDao.get(inParam.getNotation());
				if (elementObj == null) {
					this.out.setErrorMessage("Element not exist");
					return this.out;
				}
				this.out.setElement(elementObj);
				break;

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				List<Element> elementList = elementDao.list(
						inParam.getStartIndex(), inParam.getPageSize());

				if (ChemisboxUtilities.isNullOrEmpty(elementList)) {
					this.out.setErrorMessage("Not found any chemical object");
					return this.out;
				}

				Long totalRecords = elementDao.getCount();

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
				this.out.setElementList(elementList);
				break;

			case ChemisboxConstant.BUSINESS_FOR_UPDATE:
				elementObj = inParam.getElement();
				notation = elementDao.update(elementObj);
				if (ChemisboxUtilities.isNullOrEmpty(notation)) {
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

	public void setElementDao(ElementDAO elementDao) {
		this.elementDao = elementDao;
	}

}
