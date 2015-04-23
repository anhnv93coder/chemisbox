package com.chemisbox.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.FeedbackDAO;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AddNewFeedbackInputParam;
import com.chemisbox.output.AddNewFeedbackOutputParam;

@Service
@Transactional
public class AddNewFeedbackBusiness extends ChemisboxBusiness<AddNewFeedbackInputParam, AddNewFeedbackOutputParam> {

	@Autowired
	private FeedbackDAO feedbackDao;
	
	@Override
	public AddNewFeedbackOutputParam execute(AddNewFeedbackInputParam inParam)
			throws ChemisboxException {
		this.out = new AddNewFeedbackOutputParam();
		try {
			Integer feedbackId = feedbackDao.add(inParam.getFeedback());
			if(feedbackId == null){
				this.out.setErrorMessage("Send feedback is fail");
				return this.out;
			}
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setFeedbackDao(FeedbackDAO feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

}
