package com.chemisbox.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.VoteGoodAnswerInputParam;
import com.chemisbox.output.VoteGoodAnswerOutputParam;

@Service
@Transactional
public class VoteGoodAnswerBusiness extends
		ChemisboxBusiness<VoteGoodAnswerInputParam, VoteGoodAnswerOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Override
	public VoteGoodAnswerOutputParam execute(VoteGoodAnswerInputParam inParam)
			throws ChemisboxException {
		try {
			this.out = new VoteGoodAnswerOutputParam();
			if (!questionDao.doVoteGoodAnswer(inParam.getQuestionId(),
					inParam.getAnswerId())) {
				this.out.setErrorMessage("Voting fail. Please contact to administrator");
			}
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage("Voting fail. Please contact to administrator");
		}
		return this.out;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

}
