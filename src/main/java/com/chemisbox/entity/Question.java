package com.chemisbox.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_question")
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@ManyToOne
	@JoinColumn(name = "email")
	private User user;

	@Column(name = "votes")
	private int votes;

	@Column(name = "views")
	private int views;

	@Column(name = "created_date", updatable = false, insertable = false)
	private Date createdDate;

	@Column(name = "edited_date")
	private Date editedDate;

	@Column(name = "approved", insertable = false)
	private int approved;

	@Column(name = "good_answer_id", insertable = false)
	private int goodAnswerId;

	@JsonIgnore
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	private List<QuestionTag> questionTagList = new ArrayList<QuestionTag>();

	@JsonIgnore
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private List<Answer> answerList = new ArrayList<Answer>();

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public int getGoodAnswerId() {
		return goodAnswerId;
	}

	public void setGoodAnswerId(int goodAnswerId) {
		this.goodAnswerId = goodAnswerId;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<QuestionTag> getQuestionTagList() {
		return questionTagList;
	}

	public void setQuestionTagList(List<QuestionTag> questionTagList) {
		this.questionTagList = questionTagList;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}

}
