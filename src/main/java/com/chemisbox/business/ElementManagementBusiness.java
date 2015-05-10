package com.chemisbox.business;

import java.util.Date;
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

		Element elementObj = null;
		List<Element> elementList = null;
		long totalRecords = 0;
		long totalPage = 0;
		try {
			switch (inParam.getBusinessType()) {
			case ChemisboxConstant.BUSINESS_FOR_ADD:
				elementObj = elementDao.get(inParam.getElement().getNotation());
				if (elementObj != null) {
					this.out.setErrorMessage("Nguyên tố đã tồn tại.");
					return this.out;
				}

				elementDao.add(inParam.getElement());

				break;

			case ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS:
				elementObj = elementDao.get(inParam.getNotation());
				if (elementObj == null) {
					this.out.setErrorMessage("Element not exist");
					return this.out;
				}
				this.out.setElement(elementObj);
				break;

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				elementList = elementDao.list(
						inParam.getStartIndex(), inParam.getPageSize());

				if (ChemisboxUtilities.isNullOrEmpty(elementList)) {
					this.out.setErrorMessage("Not found any chemical object");
					return this.out;
				}

				totalRecords = elementDao.getCount();

				totalPage = 0;
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
				
			case ChemisboxConstant.BUSINESS_FOR_SEARCH:
				String keyWord = inParam.getKeyWord();
				
				StringBuffer buffer = new StringBuffer();
				buffer.append("%");
				buffer.append(keyWord);
				buffer.append("%");
				
				elementList = elementDao.searchByKeyWord(buffer.toString(), inParam.getStartIndex(), ChemisboxConstant.TOTAL_ELEMENT_RECORDS_IN_A_PAGE);
				if (ChemisboxUtilities.isNullOrEmpty(elementList)) {
					this.out.setErrorMessage("Không tìm thấy.");
					return this.out;
				}

				totalRecords = elementDao.getCountByKeyWord(buffer.toString());

				totalPage = 0;
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
				elementObj.setEditedDate(new Date());
				elementDao.update(elementObj);
				break;

			case ChemisboxConstant.BUSINESS_FOR_DELETE:
				String notation = inParam.getNotation();
				elementObj = elementDao.get(notation);
				if (elementObj == null) {
					this.out.setErrorMessage(String.format(
							"Nguyên tố %s không tồn tại.", notation));
				}

				elementDao.delete(elementObj);
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
