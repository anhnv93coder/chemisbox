package com.chemisbox.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chemisbox.dao.QuestionDAO;
import com.chemisbox.dao.QuestionTagDAO;
import com.chemisbox.dao.TagDAO;
import com.chemisbox.entity.Question;
import com.chemisbox.entity.QuestionTag;
import com.chemisbox.entity.Tag;
import com.chemisbox.exception.ChemisboxException;
import com.chemisbox.input.AddQuestionInputParam;
import com.chemisbox.output.AddQuestionOutputParam;

@Service
@Transactional
public class AddQuestionBusiness extends
		ChemisboxBusiness<AddQuestionInputParam, AddQuestionOutputParam> {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private TagDAO tagDao;

	@Autowired
	private QuestionTagDAO questionTagDao;

	@Override
	public AddQuestionOutputParam execute(AddQuestionInputParam inParam)
			throws ChemisboxException {
		this.out = new AddQuestionOutputParam();
		Question question = new Question();
		Tag tag = null;
		List<Tag> tagList = null;
		Integer questionId = null;
		try {

			question.setTitle(inParam.getTitle());
			question.setContent(inParam.getContent());
			question.setUser(inParam.getUser());
			question.setCreatedDate(new Date());
			questionId = questionDao.add(question);
			
			if(questionId == null){
				this.out.setErrorMessage("Add question fail");
				return this.out;
			}
			
			tagList = new ArrayList<Tag>();
			String[] tagNameArr = inParam.getTagName().split(",");
			for (int i = 0; i < tagNameArr.length; i++) {
				String tagName = tagNameArr[i].trim();
				if (tagName.length() > 0) {
					tag = tagDao.get(tagName);
					if (tag == null) {
						tag = new Tag();
						tag.setTagName(tagName);
						tagDao.add(tag);
					}
					tagList.add(tag);
				}
			}
			QuestionTag questionTag = null;
			for (int i = 0; i < tagList.size(); i++) {
				questionTag = new QuestionTag();
				questionTag.setQuestion(question);
				questionTag.setTag(tagList.get(i));
				questionTagDao.add(questionTag);
			}

		} catch (Exception e) {
			this.out.setErrorMessage(e.getMessage());
		}
		return this.out;
	}

	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}

	public void setQuestionTagDao(QuestionTagDAO questionTagDao) {
		this.questionTagDao = questionTagDao;
	}

	public void setTagDao(TagDAO tagDao) {
		this.tagDao = tagDao;
	}

}
