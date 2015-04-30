package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.LoadForumInputParam;
import com.chemisbox.output.LoadForumOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class LoadForumBusiness extends
		ChemisboxBusiness<LoadForumInputParam, LoadForumOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Override
	public LoadForumOutputParam execute(LoadForumInputParam inParam)
			throws ChemisboxException {
		this.out = new LoadForumOutputParam();
		List<Question> questionList = null;
		try {
			questionList = questionDao.selectQuestionByUser(inParam.getEmail(),
					inParam.getStartIndex(), 5);

			if (ChemisboxUtilities.isNullOrEmpty(questionList)) {
				this.out.setErrorMessage("Khong tim thay danh sach cau hoi.");
			} else {
				this.out.setQuestionList(questionList);
			}
			return this.out;
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

}
