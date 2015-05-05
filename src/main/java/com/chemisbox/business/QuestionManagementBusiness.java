package com.chemisbox.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.constant.ChemisboxConstant;
import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.dao.QuestionTagDAO;
import com.chemisbox.entity.Question;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.QuestionManagementInputParam;
import com.chemisbox.output.QuestionManagementOutputParam;
import com.chemisbox.utilities.ChemisboxUtilities;

@Service
@Transactional
public class QuestionManagementBusiness
		extends
		ChemisboxBusiness<QuestionManagementInputParam, QuestionManagementOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private QuestionTagDAO questionTagDao;

	@Override
	public QuestionManagementOutputParam execute(
			QuestionManagementInputParam inParam) throws ChemisboxException {
		Question question = null;
		this.out = new QuestionManagementOutputParam();
		try {
			switch (inParam.getBusinessType()) {
			
			case ChemisboxConstant.BUSINESS_FOR_LOAD_DETAILS:
				
				question = questionDao.get(inParam.getQuestionId());
				if(question == null){
					this.out.setErrorMessage("Not found question");
					return this.out;
				}
				this.out.setQuestion(question);
				break;

			case ChemisboxConstant.BUSINESS_FOR_LIST:
				List<Question> questionList = questionDao.selectNotApprovedQuestions(inParam.getStartIndex(), inParam.getPageSize());
				if(ChemisboxUtilities.isNullOrEmpty(questionList)){
					this.out.setErrorMessage("Không có dữ liệu.");
					return this.out;
				}
				this.out.setQuestionList(questionList);
				break;
			case ChemisboxConstant.BUSINESS_FOR_UPDATE:
				if(!questionDao.doApprove(inParam.getQuestionId())){
					this.out.setErrorMessage("Approving question is fail");
				}
				break;
			case ChemisboxConstant.BUSINESS_FOR_DELETE:
				Integer questionId = inParam.getQuestionId();
				question = questionDao.get(questionId);
				if(question == null){
					this.out.setErrorMessage("Câu hỏi không tồn tại");
					return this.out;
				}
				
				questionTagDao.delete(questionId);
				
				if(!questionDao.delete(question)){
					this.out.setErrorMessage("Xảy ra lỗi khi xóa câu hỏi.");
					return this.out;
				}
				
				break;
			default:
				throw new ChemisboxException("Business type	invalid");
			}
		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setQuestionTagDao(QuestionTagDAO questionTagDao) {
		this.questionTagDao = questionTagDao;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

}
